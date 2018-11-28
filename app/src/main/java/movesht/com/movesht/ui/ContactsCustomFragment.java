package movesht.com.movesht.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import movesht.com.movesht.Const;
import movesht.com.movesht.CustomFontsTextView;
import movesht.com.movesht.R;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.model.User;

public class ContactsCustomFragment extends BaseFragment {

    @BindView(R.id.btn_back)
    protected ImageView imgBack;
    @BindView(R.id.img_person)
    protected ImageView imgPerson;
    @BindView(R.id.tv_title)
    protected CustomFontsTextView tvTitle;

    private User user;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgBack.setOnClickListener(this);
        imgPerson.setOnClickListener(this);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            user = (User) getArguments().getSerializable(Const.USER);
            tvTitle.setText(user.getFirstname() + " " + user.getLastname());
        }
    }

    public static ContactsCustomFragment newInstance() {
        ContactsCustomFragment fragment = new ContactsCustomFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_contacts_custom;
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
//TODO
                break;
            case R.id.img_person:
                PersonFragment fragment = new PersonFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(Const.USER, user);
                fragment.setArguments(bundle);
                BaseActivity.addFragment(getAct(), PersonFragment.class, R.id.fl_container, bundle, true, true, true);
                break;
        }
    }
}
