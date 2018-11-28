package movesht.com.movesht.util;

import java.util.concurrent.TimeUnit;

import movesht.com.movesht.Const;
import movesht.com.movesht.interfaces.APIAuthInterface;
import movesht.com.movesht.model.ResponseOne;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC on 05-Apr-17.
 */

public class HTTPUtil {
    public APIAuthInterface stepOne(String userName,String password){   //+userName+"/"+password
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL+"authFirstStep/"+userName+"/"+password+"/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIAuthInterface service = retrofit.create(APIAuthInterface.class);

        return service;
    }
    public APIAuthInterface stepTwo(String userName,String password, String sms){   //+userName+"/"+password
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL+"authSecondStep/"+userName+"/"+password+"/"+sms+"/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIAuthInterface service = retrofit.create(APIAuthInterface.class);

        return service;
    }
    public APIAuthInterface singupStepOne(String userName,String password){   //+userName+"/"+password
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL+"singupStep/"+userName+"/"+password+"/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIAuthInterface service = retrofit.create(APIAuthInterface.class);

        return service;
    }
    public APIAuthInterface singupStepTwo(String userName,String password, String sms){   //+userName+"/"+password
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL+"authSecondStep/"+userName+"/"+password+"/"+sms+"/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIAuthInterface service = retrofit.create(APIAuthInterface.class);

        return service;
    }
}
