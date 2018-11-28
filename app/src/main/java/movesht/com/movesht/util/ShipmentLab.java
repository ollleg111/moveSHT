package movesht.com.movesht.util;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ShipmentLab {

    private static ShipmentLab sShipmentLab;
    private Context mContext;
    private List<Shipments> mShipments;


    public static ShipmentLab get(Context context) {
        if (sShipmentLab == null) {
            sShipmentLab = new ShipmentLab(context);
        }
        return sShipmentLab;
    }

    private ShipmentLab(Context context) {
        mShipments = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Shipments shipments = new Shipments();
            shipments.setTitle("Какой-то текст " + i);
            shipments.setMiles(10 + i);
            shipments.setCosts(2 + i);
            mShipments.add(shipments);
        }
    }

    public List<Shipments> getShipments() {
        return mShipments;
    }

    public Shipments getShipments(UUID id) {
        for (Shipments crime : mShipments) {
            if (crime.getShipments().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}

