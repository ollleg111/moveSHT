package movesht.com.movesht.util;

import android.util.Patterns;

/**
 * Created by Admin on 06.03.2017.
 */

public class ValidatorUtils {

    public static boolean isName(String name) {
        return !(name.length() < 2 || name.length() > 20);
    }

    public static boolean isValidEmail(CharSequence target) {
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean isPhone(String phone) {
        return phone.matches("^-?\\d+$");
    }

    public static boolean isPassValid(String password, String passwordRepeat) {
        return password.equals(passwordRepeat);
    }

}
