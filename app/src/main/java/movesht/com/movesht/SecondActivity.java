package movesht.com.movesht;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.SwitchCompat;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.io.Serializable;

import butterknife.BindView;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.interfaces.InterfaceRV;
import movesht.com.movesht.model.User;
import movesht.com.movesht.ui.AccountSettingsFragment;
import movesht.com.movesht.ui.BalanceFragment;
import movesht.com.movesht.ui.BrowseCatalogFragment;
import movesht.com.movesht.ui.ContactsCustomFragment;
import movesht.com.movesht.ui.ContactsFragment;
import movesht.com.movesht.ui.DutyFragment;
import movesht.com.movesht.ui.InvoicesFragment;
import movesht.com.movesht.ui.MessagesFragment;
import movesht.com.movesht.ui.MockContacts;
import movesht.com.movesht.ui.NotificationFragment;
import movesht.com.movesht.ui.OfficeFragment;
import movesht.com.movesht.ui.PersonFragment;
import movesht.com.movesht.ui.PeymentMethodFragment;
import movesht.com.movesht.ui.SettingsFragment;
import movesht.com.movesht.ui.ShipmentFragment;
import movesht.com.movesht.ui.cargo.CargoChooseFragment;

public class SecondActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.shipments)
    protected View imgBidding;
    @BindView(R.id.browse_catalog)
    protected View imgActive;
    @BindView(R.id.invoices)
    protected View imgCompleted;

    @BindView(R.id.img_menu)
    protected View imgMenu;
    @BindView(R.id.img_person)
    protected View imgPerson;

    @BindView(R.id.navigation)
    protected View navigation;

    @BindView(R.id.ll_contacts)
    protected LinearLayout llContacts;
    @BindView(R.id.ll_messages)
    protected LinearLayout llMessages;
    @BindView(R.id.ll_center)
    protected LinearLayout llOffice;
    @BindView(R.id.ll_settings)
    protected LinearLayout llSettings;
    @BindView(R.id.rl_duty)
    protected RelativeLayout rlDuty;

    @BindView(R.id.tv_nav_contacts)
    protected CustomFontsTextView tvNavContacts;
    @BindView(R.id.tv_nav_messages)
    protected CustomFontsTextView tvNavMessages;
    @BindView(R.id.tv_nav_office)
    protected CustomFontsTextView tvNavOffice;
    @BindView(R.id.tv_nav_settings)
    protected CustomFontsTextView tvNavSettings;
    @BindView(R.id.sc_nav_duty)
    protected SwitchCompat swNavDuty;
    @BindView(R.id.dl_menu)
    protected DrawerLayout drawerLayout;

    private boolean isClose = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupDrawerLayout();
        startIntroFragment();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setItemBackgroundResource(R.color.colorGrey);
//        navigation.setItemTextColor(ColorStateList
//                .valueOf(getResources().getColor(R.color.colorGrey)));
        navigation.setItemIconTintList(ColorStateList
                .valueOf(getResources().getColor(R.color.colorLightGrey)));

        tvNavContacts.setOnClickListener(this);
        tvNavMessages.setOnClickListener(this);
        tvNavOffice.setOnClickListener(this);
        tvNavSettings.setOnClickListener(this);
        swNavDuty.setOnClickListener(this);
        imgPerson.setOnClickListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_second;
    }

    private void startIntroFragment() {
        BaseActivity.addFragment(getAct(), ShipmentFragment.class,
                R.id.fl_container, null, false, true, false);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.shipments:
                    if (!(getSupportFragmentManager().
                            findFragmentById(R.id.fl_container) instanceof ShipmentFragment)) {
                        BaseActivity.addFragment(getAct(), ShipmentFragment.class,
                                R.id.fl_container, null, false, true, false);
                    }
                    return true;
                case R.id.browse_catalog:
                    BaseActivity.addFragment(getAct(), BrowseCatalogFragment.class,
                            R.id.fl_container, null, false, true, false);
                    return true;
                case R.id.invoices:
                    BaseActivity.addFragment(getAct(), InvoicesFragment.class,
                            R.id.fl_container, null, false, true, false);
                    return true;
            }
            return false;
        }
    };

    private void setupDrawerLayout() {
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                drawerLayout.openDrawer(Gravity.START);

                if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        BaseFragment baseFragment = (BaseFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fl_container);

//        if (baseFragment instanceof PersonFragment) {
//            visible();
//        }
        if (baseFragment instanceof ContactsFragment) {
            visible();
        }
        if (baseFragment instanceof MessagesFragment) {
            visible();
        }
        if (baseFragment instanceof OfficeFragment) {
            visible();
        }
        if (baseFragment instanceof SettingsFragment) {
            visible();
        }
        if (baseFragment instanceof DutyFragment) {
            visible();
        }
        if (baseFragment instanceof PeymentMethodFragment) {
            visible();
        }
        if (baseFragment instanceof AccountSettingsFragment) {
            visible();
        }
        if (baseFragment instanceof BalanceFragment) {
            visible();
        }
        if (baseFragment instanceof NotificationFragment) {
            visible();
        }
        if (baseFragment instanceof CargoChooseFragment) {
            visible();
        }
        if (baseFragment instanceof ShipmentFragment) {

            BaseActivity.addFragment(getAct(), ShipmentFragment.class,
                    R.id.fl_container, null, false, true, false);
        }
        super.onBackPressed();

        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
            drawerLayout.closeDrawer(Gravity.START);
            visible();
        }
    }

    private void invisible() {
        imgMenu.setVisibility(View.GONE);
        navigation.setVisibility(View.GONE);
    }

    private void visible() {
        imgMenu.setVisibility(View.VISIBLE);
        navigation.setVisibility(View.VISIBLE);
    }

    private void colorBack() {
        llContacts.setBackgroundResource(R.color.colorWhite);
        llMessages.setBackgroundResource(R.color.colorWhite);
        llOffice.setBackgroundResource(R.color.colorWhite);
        llSettings.setBackgroundResource(R.color.colorWhite);
        rlDuty.setBackgroundResource(R.color.colorWhite);
    }

    private void closeMethod() {
        drawerLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                colorBack();
                if (!isClose) {
                    close();
                }
            }
        }, 300);
        invisible();
    }

    public void close() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        drawerLayout.closeDrawer(Gravity.START);
    }

    @Override
    public void onClick(View v) {

        isClose = false;
        Class fragment = null;

        switch (v.getId()) {

            case R.id.tv_nav_contacts:
                llContacts.setBackgroundResource(R.color.colorLightGrey);
                fragment = ContactsFragment.class;
                break;

            case R.id.tv_nav_messages:
                llMessages.setBackgroundResource(R.color.colorLightGrey);
                fragment = MessagesFragment.class;
                break;

            case R.id.tv_nav_office:
                llOffice.setBackgroundResource(R.color.colorLightGrey);
                fragment = OfficeFragment.class;
                break;

            case R.id.tv_nav_settings:
                isClose = true;
                llSettings.setBackgroundResource(R.color.colorLightGrey);
                BaseActivity.addFragment(getAct(), SettingsFragment.class, R.id.nv_menu);
                break;

            case R.id.sc_nav_duty:
                rlDuty.setBackgroundResource(R.color.colorLightGrey);
                fragment = DutyFragment.class;
                break;

            case R.id.img_person:
                PersonFragment personFragment = new PersonFragment();
                Bundle bundle = new Bundle();
                InterfaceRV interfaceRV = new MockContacts();
                bundle.putSerializable(Const.USER, (Serializable) interfaceRV.getListUser().get(0));
                personFragment.setArguments(bundle);
                BaseActivity.addFragment(getAct(), PersonFragment.class, R.id.fl_container, bundle, true, true, true);
                //TODO
                // данные владельца взяты из списка заказчиков
                // в дальнейшем - вытянуть из регтстрации
                break;
        }
        if (fragment != null) {
            BaseActivity.addFragment(getAct(), fragment, R.id.fl_container);
        }
        closeMethod();
    }
}