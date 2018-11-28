package movesht.com.movesht.model;

import movesht.com.movesht.model.enams.TypePackage;
import movesht.com.movesht.model.enams.TypeStop;

/**
 * Created by PC on 10-Mar-17.
 */

public class MyShipment {

    private Double distance;
    private String icon;
    private Double priceFrom;
    private Double priceTo;
    private String title;
    private TypePackage typePackage;
    private TypeStop typeStop;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTypePackage() {
        return typePackage.ordinal();
    }

    public void setTypePackage(Integer ordinal) {
        this.typePackage = TypePackage.values()[ordinal];
    }

    public Integer getTypeStop() {
        return typeStop.ordinal();
    }

    public void setTypeStop(Integer ordinal) {
        this.typeStop = TypeStop.values()[ordinal];
    }

    public MyShipment(Double distance, Double priceFrom, Double priceTo, String title) {
        this.distance = distance;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.title = title;
    }

    public MyShipment() {
    }
}
