package movesht.com.movesht;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.ui.LoadAlertFragment;
import movesht.com.movesht.ui.cargo.CargoChooseFragment;

public class LoadAlertActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.btn_back)
    protected View btnBack;
    @BindView(R.id.btn_back_office)
    protected View btnBackFragment;
    @BindView(R.id.rl_title)
    protected RelativeLayout rlTitle;
    @BindView(R.id.tv_title)
    protected TextView tvTitle;
    @BindView(R.id.btn_cancel)
    protected View btnCancel;
    @BindView(R.id.btn_ok)
    protected View btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startIntroFragment();

        btnBack.setOnClickListener(this);
        btnBackFragment.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnOk.setOnClickListener(this);
    }

    private void startIntroFragment() {
        BaseActivity.addFragment(getAct(), LoadAlertFragment.class,
                R.id.fl_container, null, false, true, false);

        btnBackFragment.setVisibility(View.GONE);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_set_load_alerts;
    }


    public void colorChange() {
        rlTitle.setBackgroundResource(R.color.colorWhite);
        tvTitle.setTextColor(getResources().getColor(R.color.colorBlack));
        tvTitle.setText(getResources().getText(R.string.freight_type_alert));
        btnBackFragment.setVisibility(View.VISIBLE);
        btnBack.setVisibility(View.GONE);

    }

    private void colorBack() {
        rlTitle.setBackgroundResource(R.drawable.background_black);
        tvTitle.setTextColor(getResources().getColor(R.color.colorWhite));
        tvTitle.setText(getResources().getText(R.string.set_load_alerts));
        btnBackFragment.setVisibility(View.GONE);
        btnBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().
                findFragmentById(R.id.fl_container) instanceof CargoChooseFragment) {

            colorBack();
        }
        if (getSupportFragmentManager().
                findFragmentById(R.id.fl_container) instanceof LoadAlertFragment) {

        }
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_back:
                onBackPressed();

                break;
            case R.id.btn_cancel:

                break;
            case R.id.btn_ok:

                break;
            case R.id.btn_back_office:
                onBackPressed();
                break;
        }
    }
}
