package movesht.com.movesht.common;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import butterknife.BindView;
import movesht.com.movesht.R;

/**
 * Created by NewUser on 12/13/16.
 */

public abstract class BaseDrawerActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

//    @BindView(R.id.nav_view)
//    protected NavigationView navigationView;
    @BindView(R.id.dl_menu)
    protected DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.getLayoutParams().width = UiUtils.getScreenWidth(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    public void setDrawerState(boolean isEnabled) {
        if (isEnabled) {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
        else {
            if (drawer.isDrawerOpen(GravityCompat.END)) {
                drawer.closeDrawer(GravityCompat.END);
            }
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    }

   /* @Override
    public BaseDrawerActivity getAct() {
        return this;
    }*/
}