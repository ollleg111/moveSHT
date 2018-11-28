package movesht.com.movesht;

import android.os.Bundle;

import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.ui.FirstFragment;
import movesht.com.movesht.ui.PenFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            startIntroFragment();
        }
    }

    @Override
    public int getLayout() {
        return R.layout.activity_coordinator;
    }

    private void startIntroFragment() {
        addFragment(this, FirstFragment.class, R.id.coordinator_layout,
                null, true, false, false);
    }
}

