package movesht.com.movesht.ui.cargo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import movesht.com.movesht.CargoActivity;
import movesht.com.movesht.PagerFragmentFirst;
import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.model.ShipmentOneStopOnePickup;
import movesht.com.movesht.util.LogUtil;
import movesht.com.movesht.util.ShipmensAPIUtils;

import static movesht.com.movesht.R.id.tv_from;

/**
 * Created by Admin on 20.03.2017.
 */

public class CargoOnePackageFragment extends BaseFragment {

    ShipmentOneStopOnePickup shipmentOneStopOnePickup;

    public enum STATE {ONE, TWO}

    @BindView(tv_from)
    protected TextView tvFrom;
    @BindView(R.id.tv_to)
    protected TextView tvTo;
    @BindView(R.id.ed_first_name)
    protected EditText edFirstName;
    @BindView(R.id.ed_last_name)
    protected EditText edLastName;
    @BindView(R.id.ed_phone)
    protected EditText edPhone;
    @BindView(R.id.img_refresh)
    protected ImageView imgRefresh;
    @BindView(R.id.ed_title)
    protected EditText edTitle;
    @BindView(R.id.tv_choose)
    protected TextView tvChooseType;

    @BindView(R.id.btn_w)
    protected ToggleButton btnW;
    @BindView(R.id.tv_w)
    protected TextView tvW;
    @BindView(R.id.img_wTriangle)
    protected ImageView imgWTriangle;
    @BindView(R.id.btn_d)
    protected ToggleButton btnD;
    @BindView(R.id.tv_d)
    protected TextView tvD;
    @BindView(R.id.img_dTriangle)
    protected ImageView imgDTriangle;
    @BindView(R.id.btn_h)
    protected ToggleButton btnH;
    @BindView(R.id.tv_h)
    protected TextView tvH;
    @BindView(R.id.img_hTriangle)
    protected ImageView imgHTriangle;
    @BindView(R.id.btn_weight)
    protected ToggleButton btnWeight;
    @BindView(R.id.tv_weight)
    protected TextView tvWeight;
    @BindView(R.id.img_weightTriangle)
    protected ImageView imgWeightTriangle;
    @BindView(R.id.ed_enter)
    protected EditText edEnter;

    @BindView(R.id.tv_quantityNum)
    protected TextView tvQuantityNum;
    @BindView(R.id.img_minus)
    protected ImageView imgMinus;
    @BindView(R.id.img_plus)
    protected ImageView imgPlus;
    @Nullable
    @BindView(R.id.img_addPhotos)
    protected ImageView imgAddPhotos;
    @BindView(R.id.btn_load)
    protected ToggleButton btnLoad;
    @BindView(R.id.btn_unload)
    protected ToggleButton btnUnload;
    @BindView(R.id.btn_save)
    protected Button btnSave;
    @BindView(R.id.btn_ok)
    protected View btnOk;
    @BindView(R.id.btn_cancel)
    protected View btnCancel;
    @BindView(R.id.view_pager)
    protected ViewPager viewPager;
    @BindView(R.id.ll_one)
    protected LinearLayout llOne;

    protected STATE state;

    private PhotoSlidePagerAdapter pagerAdapter;

    @Override
    public int getLayout() {
        return R.layout.fragment_cargo_one_package;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, llOne, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if (args != null)
        {
            state = (STATE) args.getSerializable(STATE.class.getCanonicalName());

            if (state != null)

                switch (state)
                {
                    case ONE:
                        llOne.setVisibility(View.GONE);
                        break;
                    case TWO:
                        tvFrom.setVisibility(View.GONE);
                        break;
                }
        }
        if (getActivity() instanceof CargoActivity) {
            ((CargoActivity) getActivity()).titleChange();
        }
        startViewPager();
    }

    public static Bundle getBundle(STATE state) {
        Bundle args = new Bundle();
        args.putSerializable(STATE.class.getCanonicalName(), state);
        return args;
    }

    private class PhotoSlidePagerAdapter extends FragmentStatePagerAdapter {
        //        public PhotoSlidePagerAdapter(FragmentManager fm, ArrayList<Integer> IMAGES) {
        public PhotoSlidePagerAdapter(FragmentManager fm) {
            super(fm);

        }

//        public SlidingImage_Adapter(Context context,ArrayList<Integer> IMAGES) {
//            this.context = context;
//            this.IMAGES=IMAGES;
//            inflater = LayoutInflater.from(context);
//        }

        @Override
        public Fragment getItem(int position) {
//            switch (position) {

            return PagerFragmentFirst.newInstance(position);
//                case 0: return OnboardingFragment.instance(R.string.first_splash_sentences,
//                        R.drawable.one_logo);
//                case 1: return OnboardingFragment.instance(R.string.second_splash_sentences,
//                        R.drawable.one_logo);
//                case 2: return OnboardingFragment.instance(R.string.third_splash_sentences,
//                        R.drawable.one_logo);
//                case 3: return OnboardingFragment.instance(R.string.fourth_splash_sentences,
//                        -1);

        }

        @Override
        public int getCount() {
            return 1;
        }
    }

    private void startViewPager() {
        pagerAdapter = new PhotoSlidePagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setStateDimensions(ToggleButton toggleButton, View triangle, String hint) {
        if (toggleButton.isChecked()) {
            if (toggleButton.getId() != btnW.getId()) {
                if (btnW.isChecked()) {
                    if (!TextUtils.isEmpty(edEnter.getText())) {
                        LogUtil.info(this, "W: " + edEnter.getText());
                    }
                    btnW.setChecked(false);
                }
            }
            if (toggleButton.getId() != btnH.getId()) {
                btnH.setChecked(false);
            }
            if (toggleButton.getId() != btnWeight.getId()) {
                btnWeight.setChecked(false);
            }
            if (toggleButton.getId() != btnD.getId()) {
                btnD.setChecked(false);
            }

            switch (toggleButton.getId()) {
                case R.id.btn_w:
                    edEnter.setText("" + 10);
                    break;
                default:
                    edEnter.setText(null);
            }
            visibility();
            triangle.setVisibility(View.VISIBLE);
            edEnter.setVisibility(View.VISIBLE);
            edEnter.setHint(hint);
        } else {
            visibility();
            edEnter.setVisibility(View.GONE);
        }
    }

    private void visibility() {
        imgWeightTriangle.setVisibility(View.GONE);
        imgDTriangle.setVisibility(View.GONE);
        imgWTriangle.setVisibility(View.GONE);
        imgHTriangle.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_w)
    void pressBtnW() {
        setStateDimensions(btnW, imgWTriangle, "Width");
    }

    @OnClick(R.id.tv_choose)
    void pressChoose() {
        BaseActivity.addFragment(getAct(), CargoChooseFragment.class,
                R.id.fl_container, null, true, true, false);
    }

    @OnClick(R.id.btn_d)
    void btnD() {
        setStateDimensions(btnD, imgDTriangle, "Depth");
    }

    @OnClick(R.id.btn_h)
    void btnH() {
        setStateDimensions(btnH, imgHTriangle, "Height");
    }

    @OnClick(R.id.btn_weight)
    void btnWeight() {
        setStateDimensions(btnWeight, imgWeightTriangle, "Weight");
    }
//  btnBack.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.circle_blue_padding));

    @OnClick(R.id.btn_ok)
    protected void btnOkClickAction() {
        if (isTrue()) {

            shipmentOneStopOnePickup = new ShipmentOneStopOnePickup();

//            shipmentOneStopOnePickup.setShipmentFrom(tvFrom.getText().toString());
//            shipmentOneStopOnePickup.setShipmentTo(tvTo.getText().toString());
            shipmentOneStopOnePickup.setShipmentFirsname(edFirstName.getText().toString());
            shipmentOneStopOnePickup.setShipmentLastname(edLastName.getText().toString());
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

//            ShipmensAPIUtils.sentShipment(shipmentOneStopOnePickup);
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
//        BaseActivity.addFragment(getAct(), StartFragment.class, R.id.coordinator_layout,
//                null, true, true, true);
        getAct().finish();
    }

    @OnClick(R.id.btn_cancel)
    protected void btnCancelClickAction() {

        getAct().finish();
    }

    private boolean isTrue() {
        ArrayList<View> views = validation();
        if (views.size() == 0) {
            return true;
        } else {
            getAct().snackBarAction("error!", Snackbar.LENGTH_SHORT,
                    "close", new View.OnClickListener() {
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
//        if (TextUtils.isEmpty(tvFrom.getText())) {
//            views.add(tvFrom);
//        }
//        if (TextUtils.isEmpty(tvTo.getText())) {
//            views.add(tvTo);
//        }
        if (TextUtils.isEmpty(edFirstName.getText())) {
            views.add(edFirstName);
        }
        if (TextUtils.isEmpty(edLastName.getText())) {
            views.add(edLastName);
        }
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
}
