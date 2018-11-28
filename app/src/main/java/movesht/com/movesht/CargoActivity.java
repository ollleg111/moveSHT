package movesht.com.movesht;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.ui.cargo.CargoChooseFragment;
import movesht.com.movesht.ui.cargo.CargoFewPackagesFewStopsFragment;
import movesht.com.movesht.ui.cargo.CargoFewPackagesOneStopFragment;
import movesht.com.movesht.ui.cargo.CargoFragment;
import movesht.com.movesht.ui.cargo.CargoOnePackageFragment;

public class CargoActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.btn_back)
    protected View btnBack;
    @BindView(R.id.btn_back_office)
    protected View btnBackFragment;
    @BindView(R.id.btn_ok)
    protected View btnOk;
    @BindView(R.id.rl_title)
    protected RelativeLayout rlTitle;
    @BindView(R.id.tv_title)
    protected TextView tvTitle;

    private Intent mIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnBack.setOnClickListener(this);
        btnBackFragment.setOnClickListener(this);
        btnOk.setOnClickListener(this);

        startCargoFragment();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_cargo;
    }

    private void startCargoFragment() {
        BaseActivity.addFragment(getAct(), CargoFragment.class,
                R.id.fl_container, null, true, true, false);
        titleChange();
    }

    public void titleChange() {
        btnOk.setVisibility(View.GONE);
        tvTitle.setVisibility(View.GONE);
        btnBackFragment.setVisibility(View.GONE);
    }

    public void titleFew() {
        btnOk.setVisibility(View.VISIBLE);
        btnBack.setVisibility(View.VISIBLE);
        btnBackFragment.setVisibility(View.GONE);
        tvTitle.setVisibility(View.GONE);
        rlTitle.setBackgroundResource(R.drawable.background_black);
    }

    private void colorBack() {
        rlTitle.setBackgroundResource(R.drawable.background_black);
        btnBack.setVisibility(View.VISIBLE);
        titleChange();
    }

    public void colorChange() {
        rlTitle.setBackgroundResource(R.color.colorWhite);
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(getResources().getText(R.string.freight_type_alert));
        tvTitle.setTextColor(getResources().getColor(R.color.colorBlack));
        btnBackFragment.setVisibility(View.VISIBLE);
        btnBack.setVisibility(View.GONE);
        btnOk.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_back_office:
                onBackPressed();
                break;
            case R.id.btn_ok:
                pressOk();
                break;
        }
    }

    private void pressOk() {
        if (getSupportFragmentManager().findFragmentById(R.id.fl_container)
                instanceof CargoFewPackagesFewStopsFragment) {
            Toast.makeText(CargoActivity.this, "O K  -  button from activity"
                            + " + CargoFewPackagesFewStopsFragment",
                    Toast.LENGTH_SHORT).show();
        }
        if (getSupportFragmentManager().findFragmentById(R.id.fl_container)
                instanceof CargoFewPackagesOneStopFragment) {
            Toast.makeText(CargoActivity.this, "O K  -  button from activity"
                            + " + CargoFewPackagesOneStopFragment",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.fl_container)
                instanceof CargoFragment) {
            mIntent = new Intent(CargoActivity.this, SecondActivity.class);
//        mIntent.putExtra(Const.CODE_STRING, success);
            startActivity(mIntent);
        }
        if (getSupportFragmentManager().findFragmentById(R.id.fl_container)
                instanceof CargoChooseFragment) {
            colorBack();
        }
        if (getSupportFragmentManager().findFragmentById(R.id.fl_container)
                instanceof CargoOnePackageFragment) {
            colorBack();
        }
        if (getSupportFragmentManager().findFragmentById(R.id.fl_container)
                instanceof CargoFewPackagesFewStopsFragment) {
            colorBack();
        }
        if (getSupportFragmentManager().findFragmentById(R.id.fl_container)
                instanceof CargoFewPackagesOneStopFragment) {
            colorBack();
        }
        super.onBackPressed();
    }
}
