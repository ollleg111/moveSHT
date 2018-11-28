package movesht.com.movesht;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;

/**
 * Created by Admin on 31.03.2017.
 */

public class PagerFragmentFirst extends BaseFragment {

    @BindView(R.id.img_addPhotos)
    protected ImageView imgAddPhotos;

    @OnClick(R.id.img_addPhotos)
    void pressAddPhotos(){
        toNextFragment();
    }

    protected void toNextFragment() {
                BaseActivity.addFragment(getAct(), PhotoFragment.class,
                R.id.fl_container, null, true, true, true);
//
//        Intent mIntent = new Intent(getAct(), PhotoActivity.class);
//        startActivity(mIntent);
    }

    @Override
    public int getLayout() {
        return R.layout.pager_first_fragment;
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

    public static PagerFragmentFirst newInstance(int page){
        PagerFragmentFirst pagerFragmentFirst = new PagerFragmentFirst();
        Bundle arguments = new Bundle();
        arguments.putInt("img", page);
        pagerFragmentFirst.setArguments(arguments);
        return pagerFragmentFirst;
    }
}
