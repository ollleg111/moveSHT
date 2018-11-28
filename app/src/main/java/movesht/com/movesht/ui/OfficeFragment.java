package movesht.com.movesht.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import movesht.com.movesht.LoadAlertActivity;
import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;

public class OfficeFragment extends BaseFragment {

    @BindView(R.id.img_garage)
    protected View imgGarage;
    @BindView(R.id.img_services)
    protected View imgServices;
    @BindView(R.id.img_confirmed)
    protected View imgConfirmed;
    @BindView(R.id.img_baking)
    protected View imgBaking;
    @BindView(R.id.img_completed)
    protected View imgCompleted;
    @BindView(R.id.img_pass_loads)
    protected View imgPassLoads;
    @BindView(R.id.img_bid_loads)
    protected View imgBidLoads;
    @BindView(R.id.img_set_alerts)
    protected View imgSetAlerts;
    @BindView(R.id.btn_back)
    protected View btnBack;

    Intent mIntent;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgGarage.setOnClickListener(this);
        imgServices.setOnClickListener(this);
        imgConfirmed.setOnClickListener(this);
        imgBaking.setOnClickListener(this);
        imgCompleted.setOnClickListener(this);
        imgPassLoads.setOnClickListener(this);
        imgBidLoads.setOnClickListener(this);
        imgSetAlerts.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    public static OfficeFragment newInstance() {
        OfficeFragment fragment = new OfficeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_office;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.img_garage:
                Toast.makeText(getActivity(), getString(R.string.garage), Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_services:
                Toast.makeText(getActivity(), getString(R.string.services), Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_confirmed:
                Toast.makeText(getActivity(), getString(R.string.confirmed), Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_baking:
                Toast.makeText(getActivity(), getString(R.string.baking), Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_completed:
                Toast.makeText(getActivity(), getString(R.string.completed), Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_pass_loads:
                Toast.makeText(getActivity(), getString(R.string.passing_loads), Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_bid_loads:
                Toast.makeText(getActivity(), getString(R.string.bid_loads), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_back:
                getActivity().onBackPressed();
                break;
            case R.id.img_set_alerts:
                mIntent = new Intent(getActivity(), LoadAlertActivity.class);
                //        mIntent.putExtra(Const.CODE_STRING, success);
                startActivity(mIntent);
                break;
        }
    }
}
