package movesht.com.movesht.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;


public class BrowseCatalogFragment extends BaseFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public int getLayout() {
        return R.layout.fragment_browse_catalog;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    public static BrowseCatalogFragment newInstance() {
        BrowseCatalogFragment fragment = new BrowseCatalogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}
