package movesht.com.movesht.ui.cargo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import movesht.com.movesht.CargoActivity;
import movesht.com.movesht.CustomFontsEditText;
import movesht.com.movesht.CustomFontsTextView;
import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.ui.ShipmentFragment;

public class CargoFewPackagesFewStopsFragment extends BaseFragment{

    //ShipmentOneStopOnePickup shipmentOneStopOnePickup;


    @BindView(R.id.tv_from)
    protected CustomFontsTextView tvFrom;
    @BindView(R.id.ed_enter)
    protected CustomFontsEditText edEnter;
    @BindView(R.id.img_add_package)
    protected View imgAddPackages;
    @BindView(R.id.rv_one)
    protected View rvOne;

//    @BindView(R.id.fl_cargo_part)
//    protected FrameLayout flCargoPart;

    @Override
    public int getLayout() {
        return R.layout.fragment_cargo_few_packages_few_stops;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() instanceof CargoActivity) {
            ((CargoActivity) getActivity()).titleFew();
        }

        imgAddPackages.setOnClickListener(this);
    }

//    private void setStateDimensions(ToggleButton toggleButton, View triangle, String hint) {
//        if (toggleButton.isChecked()) {
//            if (toggleButton.getId() != btnW.getId()) {
//                if (btnW.isChecked()) {
//                    if (!TextUtils.isEmpty(edEnter.getText())) {
//                        LogUtil.info(this, "W: "+edEnter.getText());
//                    }
//                    btnW.setChecked(false);
//                }
//            }
//            if (toggleButton.getId()!=btnH.getId()) {
//                btnH.setChecked(false);
//            }
//            if (toggleButton.getId()!=btnWeight.getId()) {
//                btnWeight.setChecked(false);
//            }
//            if (toggleButton.getId()!=btnD.getId()) {
//                btnD.setChecked(false);
//            }
//
//            switch (toggleButton.getId()) {
//                case R.id.btn_w:
//                    edEnter.setText("" + 10);
//                    break;
//                default:
//                    edEnter.setText(null);
//            }
//
//            imgWeightTriangle.setVisibility(View.GONE);
//            imgDTriangle.setVisibility(View.GONE);
//            imgWTriangle.setVisibility(View.GONE);
//            imgHTriangle.setVisibility(View.GONE);
//
//            triangle.setVisibility(View.VISIBLE);
//            edEnter.setVisibility(View.VISIBLE);
//            edEnter.setHint(hint);
//        } else {
//            imgWeightTriangle.setVisibility(View.GONE);
//            imgDTriangle.setVisibility(View.GONE);
//            imgWTriangle.setVisibility(View.GONE);
//            imgHTriangle.setVisibility(View.GONE);
//
//            edEnter.setVisibility(View.GONE);
//        }
//    }


    private void btnOkClickAction() {
        if (isTrue()) {

//            shipmentOneStopOnePickup = new ShipmentOneStopOnePickup();
//            shipmentOneStopOnePickup.setShipmentFrom(tvFrom.getText().toString());
//            shipmentOneStopOnePickup.setShipmentTo(tvTo.getText().toString());
//            shipmentOneStopOnePickup.setShipmentFirsname(edFirstName.getText().toString());
//            shipmentOneStopOnePickup.setShipmentLastname(edLastName.getText().toString());
//            shipmentOneStopOnePickup.setShipmentCellphone(edPhone.getText().toString());
//            shipmentOneStopOnePickup.setShipmentTitle(edTitle.getText().toString());
//            shipmentOneStopOnePickup.setShipmentNameTypeShipment(tvChooseType.getText().toString());
//            shipmentOneStopOnePickup.setShipmentWidth(Double.valueOf(tvW.getText().toString()));
//            shipmentOneStopOnePickup.setShipmentDepth(Double.valueOf(tvD.getText().toString()));
//            shipmentOneStopOnePickup.setShipmentHeight(Double.valueOf(tvH.getText().toString()));
//            shipmentOneStopOnePickup.setShipmentWeight(Double.valueOf(tvWeight.getText().toString()));
//            shipmentOneStopOnePickup.setShipmentQuantity(Double.valueOf(tvQuantityNum.getText().toString()));

//            shipmentOneStopOnePickup.setShipmentPhotos(imgAddPhotos);

//            shipmentOneStopOnePickup.setShipmentLoad(Boolean.valueOf(btnLoad.getText().toString()));
//            shipmentOneStopOnePickup.setShipmentUnload(Boolean.valueOf(btnUnload.getText().toString()));

//        ShipmensAPIUtils.sentShipment(shipmentOneStopOnePickup);
//        ShipmensAPIUtils.sentShipment()


//            user.setTextPhone(edPhone.getText().toString());
//            user.setFirstname(edFirstName.getText().toString());
//            user.setLastname(edLastName.getText().toString());
//
//            UserPrifileAPIUtils.createUser(user);//на сервер авторизации клиентов
//            UserPrifileAPIUtils.createUserMail(edMail.getText().toString(), edPass.getText().toString());
//
//            LogUtil.info("send");
            toNext();
        }
    }

    private void toNext() {
        BaseActivity.addFragment(getAct(), ShipmentFragment.class,
                R.id.coordinator_layout, null, true, true, true);
        getAct().finish();
    }

    private boolean isTrue() {
        ArrayList<View> views = validation();
        if (views.size() == 0) {
            return true;
        } else {
            getAct().snackBarAction("error!", Snackbar.LENGTH_SHORT, "close", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getAct().hideSnackBar();
                }
            });
            views.clear();
            views = null;
        }
        return false;
    }

    private ArrayList<View> validation() {

        ArrayList<View> views = new ArrayList<>();
//
        if (TextUtils.isEmpty(tvFrom.getText())) {
            views.add(tvFrom);
        }
//        if (TextUtils.isEmpty(tvTo.getText())) {
//            views.add(tvTo);
//        }
//            if (TextUtils.isEmpty(edFirstName.getText())) {
//                views.add(edFirstName);
//            }
//            if (TextUtils.isEmpty(edLastName.getText())) {
//                views.add(edLastName);
//            }
//        if (TextUtils.isEmpty(edPhone.getText())) {
//            views.add(edPhone);
//        }
//        if (TextUtils.isEmpty(edTitle.getText())) {
//            views.add(edTitle);
//        }
//        if (TextUtils.isEmpty(tvChooseType.getText())) {
//            views.add(tvChooseType);
//        }
//        if (TextUtils.isEmpty(tvW.getText())) {
//            views.add(tvW);
//        }
//        if (TextUtils.isEmpty(tvD.getText())) {
//            views.add(tvD);
//        }
//        if (TextUtils.isEmpty(tvH.getText())) {
//            views.add(tvH);
//        }
//        if (TextUtils.isEmpty(tvWeight.getText())) {
//            views.add(tvWeight);
//        }
//        if (TextUtils.isEmpty(tvQuantityNum.getText())) {
//            views.add(tvQuantityNum);
//        }
////        if (TextUtils.isEmpty(tvWeight.getText())) {
////            editTexts.add(imgAddPhotos);
////        }
//        if (TextUtils.isEmpty(tvWeight.getText())) {
//            views.add(tvWeight);
//        }
//        if (TextUtils.isEmpty(btnLoad.getText())) {
//            views.add(btnLoad);
//        }
//        if (TextUtils.isEmpty(btnUnload.getText())) {
//            views.add(btnUnload);
//        }
        return views;
    }


    public static CargoFewPackagesFewStopsFragment newInstance() {
        CargoFewPackagesFewStopsFragment fragment = new CargoFewPackagesFewStopsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        switch (view.getId()) {

            case R.id.img_add_package:
                BaseActivity.addFragment(getAct(), CargoOnePackageFragment.class,
                        R.id.fl_container,CargoOnePackageFragment.getBundle(CargoOnePackageFragment.STATE.TWO), true, true, false);
                break;
        }
    }
}

