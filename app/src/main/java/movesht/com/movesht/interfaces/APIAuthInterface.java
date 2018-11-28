package movesht.com.movesht.interfaces;

import movesht.com.movesht.model.ResponseOne;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by PC on 05-Apr-17.
 */

public interface APIAuthInterface {

    @GET(" ")
    Call<ResponseOne> getData();
    //@Query("name") String resourceName, @Query("pass") String password
}
