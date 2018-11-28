package movesht.com.movesht.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.model.MyShipment;
import movesht.com.movesht.model.User;
import movesht.com.movesht.model.enams.TypePackage;

/**
 * Created by PC on 12-Apr-17.
 */

public class PostAuth {

    public static void sendUserProfile(BaseActivity activity) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String json = activity.getStorage().loadUserRegisterData();
                Gson gson = new Gson();
                User userStorage = gson.fromJson(json, User.class);
                if(userStorage!=null && !userStorage.isInfoAboutAddToDataBase() && userStorage.getTextPhone().equals(user.getUid())){
                    DatabaseReference userRef = database.getReference("users");
                    userRef.child(user.getUid()).child("firsname").setValue(userStorage.getFirstname());
                    userRef.child(user.getUid()).child("lastname").setValue(userStorage.getLastname());
                    userRef.child(user.getUid()).child("textPhone").setValue(userStorage.getTextPhone());
                    userRef.child(user.getUid()).child("textMail").setValue(userStorage.getUser_mail());

                    userStorage.setInfoAboutAddToDataBase(true);
                    String tmpUserData = gson.toJson(userStorage);
                    activity.getStorage().saveUserRegisterData(tmpUserData);
                }
                firebaseAuth.removeAuthStateListener(this);
            }
        };
        mAuth.addAuthStateListener(mAuthListener);
    }
}
    /*String ref = database.getReference("users/Bidding").push().getKey();
    MyShipment ship = new MyShipment();
        ship.setDistance(545);
                ship.setDistance(545);
                ship.setDistance(545);
                ship.setTypePackage(TypePackage.ONE.ordinal());
                ship.setTitle("test");
                ship.setPriceFrom("asf");
                database.getReference("test").push().setValue(ship);
                database.getReference("test").child("id_Shipments2").setValue(ship);*/
