package movesht.com.movesht.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DatabaseError;

import java.util.List;

import butterknife.BindView;
import movesht.com.movesht.CargoActivity;
import movesht.com.movesht.R;
import movesht.com.movesht.adapter.ShipmentAdapter;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.firebase.PostAuth;
import movesht.com.movesht.firebase.ShipmentsConnector;
import movesht.com.movesht.model.MyShipment;

public class ShipmentFragment extends BaseFragment {

    @BindView(R.id.tv_create_shipment)
    protected TextView tvCreateShipment;
    @BindView(R.id.img_bidding)
    protected ImageView imgBidding;
    @BindView(R.id.img_active)
    protected ImageView imgActive;
    @BindView(R.id.img_completed)
    protected ImageView imgCompleted;
    @BindView(R.id.rv_shipments)
    protected RecyclerView mRecycler;

    protected ShipmentAdapter shipmentAdapter;
    private List<MyShipment> mShipment;

    private Intent mIntent;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PostAuth.sendUserProfile(getAct());

        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        ShipmentsConnector.getUserShipmentsList(getAct(), new ShipmentsConnector.Callback() {
            @Override
            public void onDataChange(List<MyShipment> listFB) {
                mShipment = listFB;
                shipmentAdapter = new ShipmentAdapter(null);
                mRecycler.setAdapter(shipmentAdapter);
                shipmentAdapter.refreshList(mShipment);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        imgBidding.setOnClickListener(this);
        imgActive.setOnClickListener(this);
        imgCompleted.setOnClickListener(this);
        tvCreateShipment.setOnClickListener(this);
    }

    public static ShipmentFragment newInstance() {
        ShipmentFragment fragment = new ShipmentFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_shipment;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    private void setStateDimensions(ImageView imageView) {
        switch (imageView.getId()) {
            case R.id.img_bidding:
                if (imgBidding.isEnabled()) {
                    imgBidding.setSelected(true);
                    imgActive.setSelected(false);
                    imgCompleted.setSelected(false);
                }
                break;
            case R.id.img_active:
                if (imgActive.isEnabled()) {
                    imgBidding.setSelected(false);
                    imgActive.setSelected(true);
                    imgCompleted.setSelected(false);
                }
                break;
            case R.id.img_completed:
                if (imgCompleted.isEnabled()) {
                    imgBidding.setSelected(false);
                    imgActive.setSelected(false);
                    imgCompleted.setSelected(true);
                }
                break;
            default:
        }
    }

    @Override
    public void onClick(View v) {

        if (v instanceof ToggleButton) {
            setStateDimensions((ImageView) v);
            return;
        }
        switch (v.getId()) {
            case R.id.tv_create_shipment:
                tvCreateShipment();
                break;
            default:
        }
    }

    private void tvCreateShipment() {
        mIntent = new Intent(getActivity(), CargoActivity.class);
//        mIntent.putExtra(Const.CODE_STRING, success);
        startActivity(mIntent);
    }
}