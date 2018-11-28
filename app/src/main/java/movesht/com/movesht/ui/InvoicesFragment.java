package movesht.com.movesht.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;

public class InvoicesFragment extends BaseFragment {

    @BindView(R.id.img_add)
    protected ImageView imgAdd;

    @Override
    public int getLayout() {
        return R.layout.fragment_invoices;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    public static InvoicesFragment newInstance() {
        InvoicesFragment fragment = new InvoicesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.img_add:
                Toast.makeText(getActivity(), "A D D", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
