package movesht.com.movesht.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;

import java.util.ArrayList;

import butterknife.BindView;
import movesht.com.movesht.MainActivity;
import movesht.com.movesht.R;
import movesht.com.movesht.SecondActivity;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.interfaces.APIAuthInterface;
import movesht.com.movesht.model.ResponseOne;
import movesht.com.movesht.model.User;
import movesht.com.movesht.model.UserProfile;
import movesht.com.movesht.util.HTTPUtil;
import movesht.com.movesht.util.LogUtil;
import movesht.com.movesht.util.UserPrifileAPIUtils;
import movesht.com.movesht.util.ValidatorUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 06.03.2017.
 */

public class CreateProfileFragment extends BaseFragment{

    @BindView(R.id.ed_first_name)
    protected EditText edFirstName;
    @BindView(R.id.ed_last_name)
    protected EditText edLastName;
    @BindView(R.id.ed_mail)
    protected EditText edMail;
    @BindView(R.id.ed_phone)
    protected EditText edPhone;
    @BindView(R.id.ed_pass)
    protected EditText edPass;
    @BindView(R.id.ed_rep_pass)
    protected EditText edRepPass;

    @BindView(R.id.btn_ok)
    protected View btnOk;
    @BindView(R.id.btn_cancel)
    protected View btnCancel;

    User user;

    @Override
    public void onClick(View view) {
        super.onClick(view);

        switch (view.getId()) {

            case R.id.btn_cancel:
//                getAct().finish();
                getActivity().onBackPressed();
                break;
            case R.id.btn_ok:
                btnOkClickAction();
                break;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCancel.setOnClickListener(this);
        btnOk.setOnClickListener(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_create_profile;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    private void btnOkClickAction() {
        if (isTrue()) {
            user = new User();
            user.setTextPhone(edPhone.getText().toString());
            user.setFirstname(edFirstName.getText().toString());
            user.setLastname(edLastName.getText().toString());
            user.setUser_mail(edMail.getText().toString());
            Gson gson = new Gson();
            String userData = gson.toJson(user);

            String phone = edPhone.getText().toString();
            String pass = edPass.getText().toString();

            APIAuthInterface service = new HTTPUtil().singupStepOne(phone,pass);
            ProgressDialog progressDialog = new ProgressDialog(getContext());
            progressDialog.setCancelable(false);
            progressDialog.show();

            service.getData().enqueue(new Callback<ResponseOne>() {
                @Override
                public void onResponse(Call<ResponseOne> call, Response<ResponseOne> responseBody) {
                    progressDialog.dismiss();

                    ResponseOne response = responseBody.body();
                    if(response!=null){
                        if(response.error==0){
                            AlertDialog alertDialog = new AlertDialog.Builder(getAct())
                                    .setView(R.layout.alert_dialog)
                                    .create();
                            alertDialog.setTitle("Enter SMS");
                            alertDialog.show();

                            TextView text = (TextView) alertDialog.findViewById(R.id.ed_alert);

                            Button btn = (Button) alertDialog.findViewById(R.id.btn_alert);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    LogUtil.info(this, "go go go");
                                    alertDialog.dismiss();
                                    APIAuthInterface service2 = new HTTPUtil().singupStepTwo(phone,pass,text.getText().toString());
                                    progressDialog.show();
                                    service2.getData().enqueue(new Callback<ResponseOne>(){
                                        @Override
                                        public void onResponse(Call<ResponseOne> call, Response<ResponseOne> responseBodyTwo) {
                                            progressDialog.dismiss();

                                            ResponseOne response = responseBodyTwo.body();
                                            if(response!=null) {
                                                if (response.error == 0) {
                                                    LogUtil.info(this, "response.error == 0<create user");
                                                    getAct().getStorage().saveUserRegisterData(userData);
                                                    toNext();
                                                }
                                            }
                                        }
                                        @Override
                                        public void onFailure(Call<ResponseOne> call, Throwable t) {
                                            LogUtil.info(this, "signInWithCustomToken  - fail");
                                        }
                                    } );
                                }
                            });
                        }
                        else {
                            LogUtil.info(this, "response.error == 1< user exist");
                            AlertDialog alertDialog2 = new AlertDialog.Builder(getAct())
                                    .setView(R.layout.alert_dialog_user_exist)
                                    .create();
                            alertDialog2.show();
                            Button btne = (Button) alertDialog2.findViewById(R.id.btn_alert_exist);
                            btne.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    alertDialog2.dismiss();
                                }
                            });
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseOne> call, Throwable t) {
                    LogUtil.info(this, "onFailure");
                    progressDialog.dismiss();
                }
            });

            LogUtil.info("send");

        }
    }
    public static CreateProfileFragment newInstance() {
        CreateProfileFragment fragment = new CreateProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

//    @OnClick(R.id.btn_cancel)
//    protected void btnCancelClickAction() {
//
//        getAct().finish();
//    }

    private boolean isTrue() {

        final Animation shakeanimation = AnimationUtils.loadAnimation(getAct(), R.anim.shake);

        ArrayList<EditText> editTexts = validation();
        if (editTexts.size() == 0) {
            return true;
        } else {
            for (EditText editText : editTexts) {
                editText.startAnimation(shakeanimation);
            }

//            getAct().snackBarAction("error!", Snackbar.LENGTH_SHORT, "close", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    getAct().hideSnackBar();
//                }
//            });

            editTexts.clear();
            editTexts = null;
            return false;
        }
    }

    private void toNext() {

        BaseActivity.addFragment(getAct(), FirstFragment.class, R.id.coordinator_layout,
                null, true, true, true);
        // getAct().finish();
    }

    private UserProfile createUserProfile() {
        UserProfile userProfile = new UserProfile();
        return userProfile;
    }

    private ArrayList<EditText> validation() {
        ArrayList<EditText> editTexts = new ArrayList<>();

        if (TextUtils.isEmpty(edFirstName.getText()) || !ValidatorUtils.isName(edFirstName.getText().toString())) {
            editTexts.add(edFirstName);
        }

        if (TextUtils.isEmpty(edLastName.getText()) || !ValidatorUtils.isName(edLastName.getText().toString())) {
            editTexts.add(edLastName);
        }

        /* e-mail*/
        if (TextUtils.isEmpty(edMail.getText()) || !ValidatorUtils.isValidEmail(edMail.getText().toString())) {
            editTexts.add(edMail);
        }

        /* phone*/
        if (TextUtils.isEmpty(edPhone.getText()) || !ValidatorUtils.isName(edPhone.getText().toString())
                || !ValidatorUtils.isPhone(edPhone.getText().toString())) {
            editTexts.add(edPhone);
        }

        if (TextUtils.isEmpty(edPass.getText()) || !ValidatorUtils.isName(edPass.getText().toString())
                || !ValidatorUtils.isPassValid(edRepPass.getText().toString(), edPass.getText().toString())) {
            editTexts.add(edPass);
        }

        if (TextUtils.isEmpty(edRepPass.getText()) || !ValidatorUtils.isName(edRepPass.getText().toString())
                || !ValidatorUtils.isPassValid(edRepPass.getText().toString(), edPass.getText().toString())) {
            editTexts.add(edRepPass);
        }

        return editTexts;
    }
}
