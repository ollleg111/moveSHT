package movesht.com.movesht.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public abstract class BaseStorageAbs implements BaseStorageInterface {

    protected static BaseStorageAbs baseStorageAbs;
    protected SharedPreferences sharedPreferences;

    protected final static String TOKEN = "movesht.com.movesht.storage.token";
    protected final static String USERDATA = "register.user.data";

    @Override
    public String loadUserRegisterData() {
        return sharedPreferences.getString(USERDATA, null);
    }

    @Override
    public String loadToken() {
        return sharedPreferences.getString(TOKEN, null);
    }

    public <T extends Object> void save(String key, T value) {
        if (value instanceof String) {
            sharedPreferences.edit().putString(key, value.toString()).commit();
        }
    }
}