package movesht.com.movesht.util;

import java.util.UUID;

public class Shipments {

    private UUID mShipmentsId;

    private String mTitle;
    private int mMiles;
    private int mCosts;

    public Shipments() {
        mShipmentsId = UUID.randomUUID();
    }

    public UUID getShipments() {
        return mShipmentsId;
    }

    public int getMiles() {
        return mMiles;
    }

    public void setMiles(int miles) {
        mMiles = miles;
    }

    public int getCosts() {
        return mCosts;
    }

    public void setCosts(int costs) {
        mCosts = costs;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;

    }

}
