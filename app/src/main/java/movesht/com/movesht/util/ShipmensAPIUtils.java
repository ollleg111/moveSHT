package movesht.com.movesht.util;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import movesht.com.movesht.Const;
import movesht.com.movesht.interfaces.InterfaceRV;
import movesht.com.movesht.model.Shipment;

/**
 * Created by PC on 07-Mar-17.
 */

public class ShipmensAPIUtils implements InterfaceRV {
    private final Context context;
    FirebaseDatabase database;

    public ShipmensAPIUtils(Context context) {
        this.context = context;
    }

    public boolean sentShipment(Shipment shipment){
        if(shipment!=null){
            database = FirebaseDatabase.getInstance();

            DatabaseReference ref = database.getReference(Const.TABLE_SHIPMENS_DATA);
            ref.child("").setValue(shipment);
            return true;
        }
        return false;
    }

    @Override
    public List getListUser() {
        return null;
    }
}
