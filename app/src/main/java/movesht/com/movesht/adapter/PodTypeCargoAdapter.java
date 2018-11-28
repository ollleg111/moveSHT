package movesht.com.movesht.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import movesht.com.movesht.R;
import movesht.com.movesht.model.cargo.PodTypeCargo;

/**
 * Created by serg on 11.04.2017.
 */

public class PodTypeCargoAdapter extends RecyclerView.Adapter<PodTypeCargoAdapter.ViewHolder>{

    List<PodTypeCargo> podTypeCargoList;
    private CargoAdapter.CargoTypeCallback callback;

    public PodTypeCargoAdapter(List<PodTypeCargo> podTypeCargoList) {
        this.podTypeCargoList = podTypeCargoList;
    }

    @Override
    public PodTypeCargoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_alert, parent, false);
        return new PodTypeCargoAdapter.ViewHolder(rootView);    }

    @Override
    public void onBindViewHolder(PodTypeCargoAdapter.ViewHolder holder, int position) {
        PodTypeCargo podTypeCargo = podTypeCargoList.get(position);

        holder.mTvDialogAlert.setText(podTypeCargo.getPodType());
    }

    @Override
    public int getItemCount() {
        if (podTypeCargoList == null || podTypeCargoList.size() == 0) {
            return 0;
        }
        return podTypeCargoList.size();
    }

    public void setCallback(CargoAdapter.CargoTypeCallback callback) {
        this.callback = callback;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_dialog_alert)
        TextView mTvDialogAlert;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
