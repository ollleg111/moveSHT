package movesht.com.movesht.util;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import movesht.com.movesht.Const;
import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.model.User;
import movesht.com.movesht.model.UserProfile;

/**
 * Created by PC on 07-Mar-17.
 */

public class UserPrifileAPIUtils {
    public static boolean createUser(User user) {//это отправляется на сервер регистрации

        if(user!=null){
            FirebaseDatabase database;
            database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(Const.TABLE_USER_DATA);

            myRef.child(user.getTextPhone()).setValue(user);

            return true;
        }
        return false;
    }
    public static boolean createUserMail(String mail, String password) {//это отправляется на сервер регистрации

        if(mail!=null && password!=null){
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            mAuth.createUserWithEmailAndPassword(mail, password);
            return true;
        }
        return false;
    }
}
