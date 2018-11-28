package movesht.com.movesht.ui.cargo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ToggleButton;

import butterknife.BindView;
import movesht.com.movesht.CustomFontsButton;
import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.interfaces.ValidateChoiceInterface;
import movesht.com.movesht.model.enams.CountShipmentsEnum;

public class CargoFragment extends BaseFragment implements View.OnClickListener,
        ValidateChoiceInterface {

    @BindView(R.id.btn_package)
    protected ToggleButton btnPackage;
    @BindView(R.id.btn_lot)
    protected ToggleButton btnLot;
    @BindView(R.id.btn_one)
    protected ToggleButton btnOne;
    @BindView(R.id.btn_few)
    protected ToggleButton btnFew;
    @BindView(R.id.btn_continue)
    protected CustomFontsButton btnContinue;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPackage.setOnClickListener(this);
        btnLot.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnFew.setOnClickListener(this);
        btnContinue.setOnClickListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_cargo;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    public static CargoFragment newInstance() {
        CargoFragment fragment = new CargoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        setStatusButtonContinue(isComplete());
    }

    private void setStateDimensions(ToggleButton toggleButton) {
        switch (toggleButton.getId()) {
            case R.id.btn_package:
                if (btnPackage.isChecked()) {
                    btnOne.setChecked(true);
                } else {
                    btnOne.setChecked(false);
                }
                btnLot.setChecked(false);
                btnFew.setChecked(false);
                break;
            case R.id.btn_one:
                if (!btnLot.isChecked() && !btnPackage.isChecked()) {
                    btnOne.setChecked(false);
                } else if (btnPackage.isChecked()) {
                    btnOne.setChecked(true);
                } else if (btnLot.isChecked() && btnFew.isChecked()) {
                    btnFew.setChecked(false);
                }
                break;
            case R.id.btn_lot:
                btnPackage.setChecked(false);
                btnOne.setChecked(false);
                if (!btnLot.isChecked()) {
                    btnOne.setChecked(false);
                    btnFew.setChecked(false);
                }
                break;
            case R.id.btn_few:
                if (btnLot.isChecked()) {
                    btnOne.setChecked(false);
                } else {
                    btnFew.setChecked(false);
                }
                break;
        }
    }

    protected CountShipmentsEnum checkChoice() {
        if (btnPackage.isChecked() && btnOne.isChecked()) {
            return CountShipmentsEnum.ONE_STOP_ONE_PACKAGE;
        } else if (btnLot.isChecked() && btnOne.isChecked()) {
            return CountShipmentsEnum.FEW_STOPS_ONE_PACKAGE;
        } else if (btnLot.isChecked() && btnFew.isChecked()) {
            return CountShipmentsEnum.FEW_STOPS_FEW_PACKAGES;
        } else return CountShipmentsEnum.NONE;
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ToggleButton) {
            setStateDimensions((ToggleButton) v);
            setStatusButtonContinue(isComplete());
            return;
        }

        switch (v.getId()) {
            case R.id.btn_continue:
                toNextFragment();
                break;
            default:
        }
    }

    private void setStatusButtonContinue(boolean status) {
        btnContinue.setEnabled(status);
    }

    protected void toNextFragment() {
        switch (checkChoice()) {
            case NONE:
                break;
            case ONE_STOP_ONE_PACKAGE:
                BaseActivity.addFragment(getAct(), CargoOnePackageFragment.class,
//                        R.id.fl_container, CargoOnePackageFragment.getBundle(CargoOnePackageFragment.STATE.TWO),
                        R.id.fl_container, null, true, true, false);
                break;
            case FEW_STOPS_ONE_PACKAGE:
                BaseActivity.addFragment(getAct(), CargoFewPackagesOneStopFragment.class,
                        R.id.fl_container, null, true, true, false);
                break;
            case FEW_STOPS_FEW_PACKAGES:
                BaseActivity.addFragment(getAct(), CargoFewPackagesFewStopsFragment.class,
                        R.id.fl_container, null, true, true, false);
                break;
        }
    }

    @Override
    public boolean isComplete() {
        return !checkChoice().equals(CountShipmentsEnum.NONE);
    }
}
