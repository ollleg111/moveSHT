package movesht.com.movesht;

import movesht.com.movesht.common.BaseFragment;

/**
 * Created by Admin on 13.03.2017.
 */

public class TestFragment extends BaseFragment {


    @Override
    public int getLayout() {
        return R.layout.fragment_cargo_two;
    }

    @Override
    public MainActivity getAct() {
        return (MainActivity) getActivity();
    }
}
