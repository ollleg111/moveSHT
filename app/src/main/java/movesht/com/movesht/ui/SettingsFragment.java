package movesht.com.movesht.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import movesht.com.movesht.CustomFontsTextView;
import movesht.com.movesht.R;
import movesht.com.movesht.SecondActivity;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;

public class SettingsFragment extends BaseFragment {

    @BindView(R.id.tv_nav_back)
    protected CustomFontsTextView tvNavBack;
    @BindView(R.id.tv_nav_notification)
    protected CustomFontsTextView tvNavNotification;
    @BindView(R.id.tv_nav_acc_settings)
    protected CustomFontsTextView vNavAccSettings;
    @BindView(R.id.tv_nav_pay_method)
    protected CustomFontsTextView tvNavPeyMethod;
    @BindView(R.id.tv_nav_log_out)
    protected CustomFontsTextView tvNavLogOut;
    @BindView(R.id.tv_nav_balance)
    protected CustomFontsTextView tvNavBalance;

    @BindView(R.id.ll_acc_settings)
    protected LinearLayout llAccSettings;
    @BindView(R.id.ll_notification)
    protected LinearLayout llNotification;
    @BindView(R.id.ll_pey_method)
    protected LinearLayout llPeyMethod;
    @BindView(R.id.ll_balance)
    protected LinearLayout llBalance;
    @BindView(R.id.ll_log_out)
    protected LinearLayout llLogOut;

    SecondActivity secondActivity;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvNavBack.setOnClickListener(this);
        tvNavNotification.setOnClickListener(this);
        vNavAccSettings.setOnClickListener(this);
        tvNavPeyMethod.setOnClickListener(this);
        tvNavLogOut.setOnClickListener(this);
        tvNavBalance.setOnClickListener(this);

        llPeyMethod.setOnClickListener(this);
        llBalance.setOnClickListener(this);
        llLogOut.setOnClickListener(this);
        llNotification.setOnClickListener(this);
        llAccSettings.setOnClickListener(this);
    }

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_settings;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    private void back() {
        onBack();
        secondActivity.close();
    }

    @Override
    public void onClick(View v) {

        secondActivity = (SecondActivity) getActivity();
        Class fragment = null;

        switch (v.getId()) {

            case R.id.tv_nav_back:
                onBack();

                break;

            case R.id.tv_nav_log_out:
                llLogOut.setBackgroundResource(R.color.colorLightGrey);
                getAct().getStorage().saveToken("");
                onBack();
                getAct().onBackPressed();
                fragment = FirstFragment.class;
                break;

            case R.id.tv_nav_notification:
                llNotification.setBackgroundResource(R.color.colorLightGrey);
                back();
                fragment = NotificationFragment.class;
                break;

            case R.id.tv_nav_acc_settings:
                llAccSettings.setBackgroundResource(R.color.colorLightGrey);
                back();
                fragment = AccountSettingsFragment.class;
                break;

            case R.id.tv_nav_pay_method:
                llPeyMethod.setBackgroundResource(R.color.colorLightGrey);
                back();
                fragment = PeymentMethodFragment.class;
                break;

            case R.id.tv_nav_balance:
                llBalance.setBackgroundResource(R.color.colorLightGrey);
                back();
                fragment = BalanceFragment.class;
                break;
        }
        if (fragment != null) {

            BaseActivity.addFragment(getAct(), fragment, R.id.fl_container);
        }
    }
}
