package movesht.com.movesht.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import movesht.com.movesht.Const;
import movesht.com.movesht.model.MyShipment;
import movesht.com.movesht.model.Shipment;

/**
 * Created by PC on 20-Mar-17.
 */

public class UserShipmentsAPIUtils {
    public static boolean sentShipment(MyShipment[] myShipment){
        if(myShipment!=null){
            FirebaseDatabase database;
            database = FirebaseDatabase.getInstance();

            DatabaseReference myRef = database.getReference("this.user/Bidding");
            myRef.child("shipment.ref").setValue(myShipment);
            return true;
        }

        return false;
    }
}
