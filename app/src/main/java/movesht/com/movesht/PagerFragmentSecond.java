package movesht.com.movesht;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;

/**
 * Created by Admin on 31.03.2017.
 */

public class PagerFragmentSecond extends BaseFragment {

    @BindView(R.id.img_pager)
    protected ImageView imgView;

    @Override
    public int getLayout() {
        return R.layout.pager_second_fragment;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static PagerFragmentSecond newInstance(int page){
        PagerFragmentSecond pagerFragmentSecond = new PagerFragmentSecond();
        Bundle arguments = new Bundle();
        arguments.putInt("img", page);
        pagerFragmentSecond.setArguments(arguments);
        return pagerFragmentSecond;
    }
}
