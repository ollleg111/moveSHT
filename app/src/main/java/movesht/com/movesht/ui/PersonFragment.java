package movesht.com.movesht.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

import butterknife.BindView;
import movesht.com.movesht.Const;
import movesht.com.movesht.CustomFontsTextView;
import movesht.com.movesht.R;
import movesht.com.movesht.adapter.PersonPhotoAdapter;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.interfaces.InterfaceRV;
import movesht.com.movesht.model.PersonType;
import movesht.com.movesht.model.User;
import movesht.com.movesht.util.LogUtil;

public class PersonFragment extends BaseFragment {

    @BindView(R.id.img_person)
    protected View imgPerson;
    @BindView(R.id.tv_person)
    protected CustomFontsTextView tvPerson;
    @BindView(R.id.tv_count)
    protected CustomFontsTextView tvCount;
    @BindView(R.id.btn_pen)
    protected ImageView btnPen;
    @BindView(R.id.btn_plus)
    protected ToggleButton btnPlus;
    @BindView(R.id.btn_photo)
    protected ImageView btnPhoto;
    @BindView(R.id.btn_movie)
    protected ImageView btnMovie;
    @BindView(R.id.recycler_view_person)
    RecyclerView mRecyclerViewPerson;

    protected PersonPhotoAdapter mPersonPhotoAdapter;

    List<PersonType> mPersonPhoto;

    private User user;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerViewPerson.setLayoutManager(new LinearLayoutManager(getContext()));

        mPersonPhotoAdapter = new PersonPhotoAdapter(null);
        mRecyclerViewPerson.setAdapter(mPersonPhotoAdapter);
        InterfaceRV interfaceRV = new MockPhotos();
        mPersonPhoto = interfaceRV.getListUser();
        mPersonPhotoAdapter.refreshList(mPersonPhoto);

        imgPerson.setOnClickListener(this);
        tvCount.setOnClickListener(this);
        btnPen.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnPhoto.setOnClickListener(this);
        btnMovie.setOnClickListener(this);

        btnPlus.getParent().requestDisallowInterceptTouchEvent(true);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            user = (User) getArguments().getSerializable(Const.USER);
            tvPerson.setText(user.getFirstname() + " " + user.getLastname());
        }else{
            tvPerson.setText(getResources().getText(R.string.person));
        }
    }

    public static PersonFragment newInstance() {
        PersonFragment fragment = new PersonFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_person;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    private void setStateDimensions(ToggleButton toggleButton) {
        switch (toggleButton.getId()) {
            case R.id.btn_plus:
                if (btnPlus.isChecked()) {
                    btnPhoto.setVisibility(View.VISIBLE);
                    btnMovie.setVisibility(View.VISIBLE);
                    btnPen.setVisibility(View.VISIBLE);
                }
                else {
                    btnPhoto.setVisibility(View.GONE);
                    btnMovie.setVisibility(View.GONE);
                    btnPen.setVisibility(View.GONE);
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.img_person:
                Toast.makeText(getActivity(), "P E R S O N", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_person:

                break;
            case R.id.tv_count:

                break;
            case R.id.btn_pen:
                BaseActivity.addFragment(getAct(), PenFragment.class, R.id.fl_container, null, true, true, true);
                break;
            case R.id.btn_plus:
                setStateDimensions((ToggleButton) v);
                break;
            case R.id.btn_photo:
                openGallery();
                break;
            case R.id.btn_movie:

                break;
        }
    }

    public void openGallery() {
        LogUtil.info(this, "openGallery");
//        if (Build.VERSION.SDK_INT >= 23) {
//            int iteration = getArguments().getInt(OPEN_GALLERY, 0);
//            if (iteration > 2) {
//                Toast.makeText(getContext(), "Permission error!", Toast.LENGTH_SHORT).show();
//                getArguments().putInt(OPEN_GALLERY, 0);
//                return;
//            }
//
//            if (!getAct().isStoragePermissionGranted()) {
//                getArguments().putInt(OPEN_GALLERY, ++iteration);
//                return;
//            }
//
//            getArguments().putInt(OPEN_GALLERY, 0);
//        }

        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        setTargetFragment(this, Const.INTENT_RESULT);
        startActivityForResult(galleryIntent, Const.INTENT_RESULT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case Const.INTENT_RESULT:
//                data.getExtras().
//                    String FilePath = data.getData().getPath();
//                    textFile.setText(FilePath);
                break;
        }
    }
}

