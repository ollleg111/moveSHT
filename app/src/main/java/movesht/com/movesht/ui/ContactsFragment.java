package movesht.com.movesht.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import movesht.com.movesht.Const;
import movesht.com.movesht.R;
import movesht.com.movesht.adapter.ContactAdapter;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.interfaces.InterfaceRV;
import movesht.com.movesht.model.User;

public class ContactsFragment extends BaseFragment implements ContactAdapter.PersonClickListener {

    @BindView(R.id.btn_back)
    protected ImageView imgBack;
    @BindView(R.id.img_loop)
    protected ImageView imgLoop;
    @BindView(R.id.rv_contacts)
    protected RecyclerView mRecycler;

    protected ContactAdapter contactAdapter;
    List<User> mContactUser;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        InterfaceRV interfaceRV = new MockContacts();

        mContactUser = interfaceRV.getListUser();
        contactAdapter = new ContactAdapter(mContactUser, this);
        mRecycler.setAdapter(contactAdapter);

//        mContactUser = interfaceRV.getListUser();
//        contactAdapter.refreshList(mContactUser);

        imgBack.setOnClickListener(this);
        imgLoop.setOnClickListener(this);
    }

    public static ContactsFragment newInstance() {
        ContactsFragment fragment = new ContactsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_contacts;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_back:
                getActivity().onBackPressed();
                break;

            case R.id.img_loop:
                Toast.makeText(getActivity(), "L O O P", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(User user) {
        ContactsCustomFragment fragment = new ContactsCustomFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Const.USER, user);
        fragment.setArguments(bundle);
        BaseActivity.addFragment(getAct(), ContactsCustomFragment.class, R.id.fl_container, bundle, true, true, true);
    }
}
