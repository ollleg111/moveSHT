package movesht.com.movesht.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;

public class BalanceFragment extends BaseFragment {

    @BindView(R.id.btn_back)
    protected ImageView imgBack;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgBack.setOnClickListener(this);
    }

    public static BalanceFragment newInstance() {
        BalanceFragment fragment = new BalanceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_balance;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_back:
                getAct().onBackPressed();
                break;
        }
    }
}
