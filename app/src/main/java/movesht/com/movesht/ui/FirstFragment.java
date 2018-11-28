package movesht.com.movesht.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import movesht.com.movesht.CustomFontsEditText;
import movesht.com.movesht.CustomFontsTextView;
import movesht.com.movesht.R;
import movesht.com.movesht.SecondActivity;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.common.BaseFragment;
import movesht.com.movesht.interfaces.APIAuthInterface;
import movesht.com.movesht.model.ResponseOne;
import movesht.com.movesht.util.HTTPUtil;
import movesht.com.movesht.util.LogUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends BaseFragment {

    @BindView(R.id.img_two)
    protected View imgTwo;
    @BindView(R.id.ed_login)
    protected CustomFontsEditText edLogin;
    @BindView(R.id.ed_password)
    protected CustomFontsEditText edPassword;
    @BindView(R.id.tv_sign)
    protected CustomFontsTextView tvSign;
    @BindView(R.id.tv_demo)
    protected CustomFontsTextView tvDemo;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Intent mIntent;
    private ProgressDialog progressDialog;

    @Override
    public int getLayout() {
        return R.layout.fragment_first;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return (T) getActivity();
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvSign.setOnClickListener(this);
        tvDemo.setOnClickListener(this);
        imgTwo.setOnClickListener(this);
    }

    private void startSecondActivity() {
        mIntent = new Intent(getActivity(), SecondActivity.class);
//        mIntent.putExtra(Const.CODE_STRING, success);
        startActivity(mIntent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        String token = getAct().getStorage().loadToken();
        if(!TextUtils.isEmpty(token)){
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setCancelable(false);
            progressDialog.show();
            mAuth.signInWithCustomToken(token)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (progressDialog != null && progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                            LogUtil.info(this, "loadToken  - onComplete");
                            Intent i = new Intent(getAct(), SecondActivity.class);
                            startActivity(i);
                        }
                    });
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.tv_sign:
//                BaseActivity.addFragment(getAct(), CreateProfileFragment.class, R.id.coordinator_layout, null, true, true, true);
                Log.d("tvSignOn", ":");
                SignUP();
                break;
            case R.id.tv_demo:
                startSecondActivity();
                Log.d("tvDemo", ":");
                break;
            case R.id.img_two:
                signIn();
                Toast.makeText(getActivity(), "Let`s get it started", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void SignUP() {
        BaseActivity.addFragment(getAct(), CreateProfileFragment.class, R.id.coordinator_layout,
                null, true, true, true);
    }

    private void signIn() {
        Log.d("startFr", "signIn");
//        if (!validateForm()) {
//            return;
//        }
        String userName = edLogin.getText().toString();
        String password = edPassword.getText().toString();
//        String userName = "+12345678901";
//        String password = "123";


        APIAuthInterface service = new HTTPUtil().stepOne(userName,password);
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
                                LogUtil.info(this, "alertDialog onClick");
                                alertDialog.dismiss();
                                APIAuthInterface service2 = new HTTPUtil().stepTwo(userName,password,text.getText().toString());
                                progressDialog.show();
                                service2.getData().enqueue(new Callback<ResponseOne>(){
                                    @Override
                                    public void onResponse(Call<ResponseOne> call, Response<ResponseOne> responseBodyTwo) {
                                        progressDialog.dismiss();

                                        ResponseOne response = responseBodyTwo.body();
                                        if(response!=null) {
                                            if (response.error == 0) {
                                                progressDialog.show();
                                                getAct().getStorage().saveToken(response.date);
                                                mAuth.signInWithCustomToken(response.date)
                                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                                progressDialog.dismiss();
                                                                LogUtil.info(this, "mAuth  - onComplete");
                                                                Intent i = new Intent(getAct(), SecondActivity.class);
                                                                startActivity(i);
                                                            }
                                                        });
                                            }
                                        }
                                        else {
                                            LogUtil.info(this, "error: "+response.date);
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
                    else {//TODO тут логин /пароль не верный отловить над :)
                        AlertDialog alertDialog2 = new AlertDialog.Builder(getAct())
                                .setView(R.layout.alert_dialog_login)
                                .create();
                        alertDialog2.show();
                        Button btne = (Button) alertDialog2.findViewById(R.id.btn_alert_incorect_login);
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if((progressDialog != null) && progressDialog.isShowing() ){
            progressDialog.dismiss();
        }
    }
}
