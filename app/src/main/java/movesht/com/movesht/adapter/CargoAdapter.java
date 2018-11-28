package movesht.com.movesht.adapter;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import movesht.com.movesht.R;
import movesht.com.movesht.model.cargo.CargoType;
import movesht.com.movesht.model.cargo.PodTypeCargo;
import movesht.com.movesht.util.LogUtil;

public class CargoAdapter extends RecyclerView.Adapter<CargoAdapter.ViewHolder> implements View.OnClickListener {

    List<CargoType> cargoList;
    private RecyclerView recyclerView;
    private AlertDialog dialog;

    public CargoAdapter(List<CargoType> cargoList) {
        this.cargoList = cargoList;
    }

    @Override
    public CargoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cargo, parent, false);
        ViewHolder holder = new CargoAdapter.ViewHolder(rootView);
        holder.btn.setOnClickListener(this);
        holder.mTitleImage.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(CargoAdapter.ViewHolder holder, int position) {
        CargoType cargoTypes = cargoList.get(position);

//        holder.mTitleImage.setImageResource(cargoTypes.getImage().getResId());
        holder.mTvModelName.setText(cargoTypes.getName());

        //        gs://testmovesht-1aa6e.appspot.com/images/IconCargoType/hdpi/ic_food_black.png
        StorageReference storageRef = null;
        String mess = holder.mTitleImage.getResources().getString(R.string.ratio);

        switch (mess) {
            case "hdpi":
                storageRef = FirebaseStorage.getInstance().getReferenceFromUrl(cargoTypes.getUrl_hdpi());
                break;
            case "xhdpi":
                storageRef = FirebaseStorage.getInstance().getReferenceFromUrl(cargoTypes.getUrl_xhdpi());
                break;
            case "xxhdpi":
                storageRef = FirebaseStorage.getInstance().getReferenceFromUrl(cargoTypes.getUrl_xxhdpi());
                break;
            case "xxxhdpi":
                storageRef = FirebaseStorage.getInstance().getReferenceFromUrl(cargoTypes.getUrl_xxxhdpi());
                break;
        }

        Glide
                .with(holder.mTitleImage.getContext())
                .using(new FirebaseImageLoader())
                .load(storageRef)
                .into(holder.mTitleImage);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @Override
    public int getItemCount() {
        if (cargoList == null || cargoList.size() == 0) {
            return 0;
        }
        return cargoList.size();
    }

    public void refreshList(List<CargoType> mCargoType) {
        cargoList = mCargoType;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        int position = recyclerView.getChildAdapterPosition((View) v.getParent());
        LogUtil.info(this, "Click: " + cargoList.get(position));
        startAlerDialog(cargoList.get(position));
    }

    private void startAlerDialog(CargoType cargoType) {
        if (dialog!=null && dialog.isShowing()) return;

        View mLayout = LayoutInflater.from(recyclerView.getContext())
                .inflate(R.layout.dialog_cargo_type, null);

        RecyclerView recyclerCargoType = (RecyclerView) mLayout.findViewById(R.id.recycler_view_dialog);
        recyclerCargoType.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        PodTypeCargoAdapter podTypeCargoAdapter = new PodTypeCargoAdapter(cargoType.getListExtra());
        CargoTypeCallback cargoTypeCallback = new CargoTypeCallback() {
            @Override
            public void onChoice(PodTypeCargo podTypeCargo) {
                LogUtil.info(this, "PodTypeCargo: " + podTypeCargo);
                dialog.dismiss();
                dialog = null;
            }
        };
        podTypeCargoAdapter.setCallback(cargoTypeCallback);
        recyclerCargoType.setAdapter(podTypeCargoAdapter);

        dialog = new AlertDialog.Builder(recyclerView.getContext())
                .setView(mLayout)
//                .setTitle(cargoType.getName())
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        CargoAdapter.this.dialog = null;
                        dialog.dismiss();
                    }
                })
                .create();
        TextView title = new TextView(recyclerView.getContext());

        title.setText(cargoType.getName());
        title.setBackgroundColor(Color.WHITE);
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);
        title.setTextColor(Color.BLACK);
        title.setTextSize(20);

        dialog.setCustomTitle(title);

        dialog.show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_model_name)
        TextView mTvModelName;
        @BindView(R.id.title_image)
        ImageView mTitleImage;
        @BindView(R.id.btn)
        Button btn;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface CargoTypeCallback {
        void onChoice(PodTypeCargo podTypeCargo);
    }
}