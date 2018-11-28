package movesht.com.movesht.model;

/**
 * Created by PC on 20-Mar-17.
 */

public class ShipmentOneStopOnePickup extends Shipment {

    private String shipmentFrom;    //Coordinate
    private String shipmentTo;      //Coordinate
    private String shipmentFirsname;
    private String shipmentLastname;
    private String shipmentCellphone;
    // title - String shipmentTitle
    // cargoClass - String shipmentNameTypeShipment
    // width - Double shipmentWidth;
    // depth - Double shipmentDepth;
    // height - Double shipmentHeight;
    // weight - Double shipmentWeight;
    // quantity - Double shipmentQuantity
    // addPhotos - String[] shipmentPhotos
    //load - Boolean shipmentLoad
    //unload - Boolean shipmentUnload



    private Double shipmentPriceFrom;
    private Double shipmentPriceTo;
    private String shipmentToName;
    private String shipmentFromName;


    public String getShipmentFromName() {
        return shipmentFromName;
    }

    public void setShipmentFromName(String shipmentFromName) {
        this.shipmentFromName = shipmentFromName;
    }

    public String getShipmentFrom() {
        return shipmentFrom;
    }

    public void setShipmentFrom(String shipmentFrom) {
        this.shipmentFrom = shipmentFrom;
    }

    public String getShipmentToName() {
        return shipmentToName;
    }

    public void setShipmentToName(String shipmentToName) {
        this.shipmentToName = shipmentToName;
    }

    public String getShipmentTo() {
        return shipmentTo;
    }

    public void setShipmentTo(String shipmentTo) {
        this.shipmentTo = shipmentTo;
    }

    public String getShipmentCellphone() {
        return shipmentCellphone;
    }

    public void setShipmentCellphone(String shipmentCellphone) {
        this.shipmentCellphone = shipmentCellphone;
    }

    public String getShipmentFirsname() {
        return shipmentFirsname;
    }

    public void setShipmentFirsname(String shipmentFirsname) {
        this.shipmentFirsname = shipmentFirsname;
    }

    public String getShipmentLastname() {
        return shipmentLastname;
    }

    public void setShipmentLastname(String shipmentLastname) {
        this.shipmentLastname = shipmentLastname;
    }

    public Double getShipmentPriceFrom() {
        return shipmentPriceFrom;
    }

    public void setShipmentPriceFrom(Double shipmentPriceFrom) {
        this.shipmentPriceFrom = shipmentPriceFrom;
    }

    public Double getShipmentPriceTo() {
        return shipmentPriceTo;
    }

    public void setShipmentPriceTo(Double shipmentPriceTo) {
        this.shipmentPriceTo = shipmentPriceTo;
    }



}
