package movesht.com.movesht.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import movesht.com.movesht.CustomFontsTextView;
import movesht.com.movesht.R;
import movesht.com.movesht.model.MyShipment;

/**
 * Created by Admin on 07.04.2017.
 */

public class ShipmentAdapter extends RecyclerView.Adapter<ShipmentAdapter.ViewHolder> {

    List<MyShipment> shipmentList;

    public ShipmentAdapter(ArrayList<MyShipment> shipmentList) {
        this.shipmentList = shipmentList;
    }


    @Override
    public ShipmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shipments, parent, false);
        return new ShipmentAdapter.ViewHolder(rootView);    }

    @Override
    public void onBindViewHolder(ShipmentAdapter.ViewHolder holder, int position) {

        MyShipment myShipment = shipmentList.get(position);

//        holder.mIcon.setImageResource(myShipment.get);

        holder.mTitle.setText(myShipment.getTitle());
        holder.mDistance.setText(String.valueOf(myShipment.getDistance()) + " mi");
        holder.mPrice.setText(myShipment.getPriceFrom() + " - " + myShipment.getPriceTo() + " $");
    }

    @Override
    public int getItemCount() {
        if (shipmentList == null || shipmentList.size() == 0) {
            return 0;
        }
        return shipmentList.size();
    }

    public void refreshList(List<MyShipment> mShipment) {
        shipmentList = mShipment;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_icon)
        ImageView mIcon;
        @BindView(R.id.tv_title)
        CustomFontsTextView mTitle;
        @BindView(R.id.tv_distance)
        CustomFontsTextView mDistance;
        @BindView(R.id.tv_price)
        CustomFontsTextView mPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
