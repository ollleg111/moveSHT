package movesht.com.movesht.storage;

/**
 * Created by PC on 07-Apr-17.
 */

public interface BaseStorageInterface {
    void saveToken(String token);
    String loadToken();
    void saveUserRegisterData(String data);
    String loadUserRegisterData();
}
