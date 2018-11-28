package movesht.com.movesht.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import butterknife.BindView;
import movesht.com.movesht.CustomFontsButton;
import movesht.com.movesht.CustomFontsEditText;
import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.ui.cargo.CargoChooseFragment;

public class LoadAlertFragment extends BaseFragment {

    public enum STATUS {GIFT, TRUCK}

    @BindView(R.id.img_gift)
    protected ImageView btnGift;
    @BindView(R.id.img_truck)
    protected ImageView btnTruck;
    @BindView(R.id.btn_w)
    protected ToggleButton btnW;
    @BindView(R.id.btn_d)
    protected ToggleButton btnD;
    @BindView(R.id.btn_h)
    protected ToggleButton btnH;
    @BindView(R.id.rv_set_load_alerts)
    protected RecyclerView rvSetLoadAlerts;
    @BindView(R.id.ed_pounds)
    protected CustomFontsEditText edPounds;
    @BindView(R.id.ed_ml)
    protected CustomFontsEditText edMl;
    @BindView(R.id.btn_pounds)
    protected Button btnPounds;
    @BindView(R.id.btn_ml)
    protected Button btnMl;
    @BindView(R.id.btn_pick)
    protected CustomFontsButton btnPick;

    protected STATUS status;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnGift.setOnClickListener(this);
        btnTruck.setOnClickListener(this);
        btnW.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnH.setOnClickListener(this);
        btnGift.setOnClickListener(this);
        btnPounds.setOnClickListener(this);
        btnMl.setOnClickListener(this);
        btnPick.setOnClickListener(this);
        btnPick.setEnabled(false);
    }

    public static LoadAlertFragment newInstance(/*int pounds, int miles*/) {
        LoadAlertFragment fragment = new LoadAlertFragment();
        Bundle args = new Bundle();
//        args.putInt(String.valueOf(Const.POUNDS), pounds);
//        args.putInt(String.valueOf(Const.MILES), miles);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_set_load_alerts;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    private void backStatus() {

        btnGift.setTag(null);
        btnTruck.setTag(null);
        btnGift.setBackgroundResource(R.drawable.circle_button_black);
        btnTruck.setBackgroundResource(R.drawable.circle_button_black);
        btnPick.setEnabled(false);
    }

    @Override
    public void onClick(View v) {

        int howPounds = 0;
        int howMiles = 0;

            Log.e("!!!!!", "!!!!!" + v.getId());
 
        switch (v.getId()) {

            case R.id.img_gift:
                if (btnGift.getTag() == null) {
                    btnGift.setTag("");
                    btnTruck.setTag(null);
                    btnGift.setBackgroundResource(R.drawable.circle_blue);
                    btnTruck.setBackgroundResource(R.drawable.circle_button_black);
                    btnPick.setEnabled(true);
                    status = STATUS.GIFT;
                } else {
                    backStatus();
                }
                break;
            case R.id.img_truck:
                if (btnTruck.getTag() == null) {
                    btnTruck.setTag("");
                    btnGift.setTag(null);
                    btnTruck.setBackgroundResource(R.drawable.circle_blue);
                    btnGift.setBackgroundResource(R.drawable.circle_button_black);
                    btnPick.setEnabled(true);
                    status = STATUS.TRUCK;
                } else {
                    backStatus();
                }
                break;
            case R.id.btn_w:

                break;
            case R.id.btn_d:

                break;
            case R.id.btn_h:

                break;
            case R.id.btn_pounds:
                if (TextUtils.isEmpty(edPounds.getText()) || !TextUtils.
                        isDigitsOnly(edPounds.getText())) {
                    Toast.makeText(getActivity(), "Please writes, how much pound do you carry?",
                            Toast.LENGTH_SHORT).show();
                } else {
                    howPounds = Integer.parseInt(edPounds.getText().toString());
                    Toast.makeText(getActivity(), howPounds + " pounds", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_ml:
                if (TextUtils.isEmpty(edMl.getText()) || !TextUtils.
                        isDigitsOnly(edMl.getText())) {
                    Toast.makeText(getActivity(), "Please writes, what is the radius searching?",
                            Toast.LENGTH_SHORT).show();
                } else {
                    howMiles = Integer.parseInt(edMl.getText().toString());
                    Toast.makeText(getActivity(), howMiles + " miles", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_pick:
                if (status != null)
                    switch (status) {
                        case GIFT:
                            BaseActivity.addFragment(getAct(), CargoChooseFragment.class,
                                    R.id.fl_container, null, true, true, true);
                            break;
                        case TRUCK:
                            BaseActivity.addFragment(getAct(), CargoChooseFragment.class,
                                    R.id.fl_container, null, true, true, true);
                            break;
                    }
                break;
        }
    }
}
