package movesht.com.movesht.storage;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by PC on 07-Apr-17.
 */

public class BaseStorage extends BaseStorageAbs {

    public static BaseStorageAbs instance(Context context) {
        if (baseStorageAbs == null) {
            baseStorageAbs = new BaseStorage(context);
        }
        return baseStorageAbs;
    }

    private BaseStorage(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void saveToken(String token) {
        save(TOKEN, token);
    }

    @Override
    public void saveUserRegisterData(String data) {
        save(USERDATA, data);
    }
}
