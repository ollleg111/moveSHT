package movesht.com.movesht;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.util.LogUtil;

/**
 * Created by Admin on 31.03.2017.
 */

public class PhotoFragment extends BaseFragment{

    @BindView(R.id.btn_camera)
    protected Button btnCamera;
    @BindView(R.id.btn_gallery)
    protected Button btnGallery;

    @Override
    public int getLayout() {
        return R.layout.fragment_photo;
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
        btnCamera.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_camera:
                takePhoto();
                break;
            case R.id.btn_gallery:
                openGallery();
                break;
        }
    }

    protected void openGallery() {
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

    protected void takePhoto() {
//        LogUtil.info(this, "takePhoto");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            int iteration = getArguments().getInt(TAKE_PHOTO, 0);
//            if (iteration > 2) {
//                Toast.makeText(getContext(), "Permission error!", Toast.LENGTH_SHORT).show();
//                getArguments().putInt(TAKE_PHOTO, 0);
//                return;
//            }
//
//            if (!getAct().isTakePhotoPermissionGranted()) {
//                getArguments().putInt(TAKE_PHOTO, ++iteration);
//                return;
//            }
//
//            getArguments().putInt(TAKE_PHOTO, 0);
//        }

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getAct().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                //String imageFileName = "JPEG_" + timeStamp + "_";
                String imageFileName = "first_screen";
                photoFile = createImageFile(imageFileName);
                // Save a file: path for use with ACTION_VIEW intents
//                mCurrentPhotoPath = photoFile.getAbsolutePath();
            } catch (IOException ex) {
                // Error occurred while creating the File
                ex.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getContext(),
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                setTargetFragment(this, Const.INTENT_PHOTO_RESULT);
                startActivityForResult(takePictureIntent, Const.INTENT_PHOTO_RESULT);
            }
        }
    }
}
