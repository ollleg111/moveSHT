package movesht.com.movesht.firebase;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;
import java.util.List;

import movesht.com.movesht.common.BaseActivity;
import movesht.com.movesht.model.MyShipment;
import movesht.com.movesht.model.enams.TypePackage;
import movesht.com.movesht.model.enams.TypeStop;
import movesht.com.movesht.model.shipments.Bidding;

/**
 * Created by PC on 12-Apr-17.
 */

public class ShipmentsConnector {
    public static void getUserShipmentsList(BaseActivity activity, Callback callback) {
        List<MyShipment> list = new LinkedList<MyShipment>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    DatabaseReference myRef = database.getReference("users/" + user.getUid());

                    myRef.child("Bidding").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                postSnapshot.getValue(MyShipment.class);
                                list.add(postSnapshot.getValue(MyShipment.class));
                            }
                            if (callback != null) callback.onDataChange(list);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            if (callback != null) callback.onCancelled(error);
                        }
                    });
                }
                firebaseAuth.removeAuthStateListener(this);
            }
        };
        mAuth.addAuthStateListener(mAuthListener);
    }

    public interface Callback {
        void onDataChange(List<MyShipment> bidding);

        void onCancelled(DatabaseError error);
    }
}
