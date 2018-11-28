package movesht.com.movesht.model;

import movesht.com.movesht.model.enams.TypePackage;
import movesht.com.movesht.model.enams.TypeStop;

/**
 * Created by PC on 10-Mar-17.
 */

public class Shipment {

//    public String getShipmentRef() {
//        return shipmentRef;
//    }

    private String shipmentRef;
    private String shipmentKey;
    private String ownerUser;
    private TypeStop tipeStop;
    private TypePackage typePackage;
    private Double distance;
    private Double time;

    private Boolean shipmentLoad;
    private Boolean shipmentUnload;
    private Double shipmentQuantity;
    private String shipmentTitle;

    private int shipmentIndexTypeShipment;
    private String shipmentNameTypeShipment;

    private Double shipmentWidth;
    private Double shipmentDepth;
    private Double shipmentHeight;
    private Double shipmentWeight;

    private String shipmentCarMake;
    private String shipmentCarModel;
    private String shipmentCarYear;
    private String shipmentCarOperational;

    private Double shipmentLooseVolume;
    private Double shipmentLooseWeight;

    private Double shipmentLiquidVolum;
    private Double shipmentLiquidWeight;
    private int shipmentLiquidPacked;

    private Double shipmentAgriculturalVolume;
    private Double shipmentAgriculturalWeight;
    private int shipmentAgriculturalPacked;

    private String shipmentAnimalsSize;
    private Boolean shipmentAnimalsCage;

    private String[] shipmentPhotos;

    public String getShipmentKey() {
        return shipmentKey;
    }

    public String getOwnerUser() {
        return ownerUser;
    }

    public TypeStop getTipeStop() {
        return tipeStop;
    }

    public TypePackage getTypePackage() {
        return typePackage;
    }

    public Double getDistance() {
        return distance;
    }

    public Double getTime() {
        return time;
    }

    public Boolean getShipmentLoad() {
        return shipmentLoad;
    }

    public Boolean getShipmentUnload() {
        return shipmentUnload;
    }

    public Double getShipmentQuantity() {
        return shipmentQuantity;
    }

    public String getShipmentTitle() {
        return shipmentTitle;
    }

    public int getShipmentIndexTypeShipment() {
        return shipmentIndexTypeShipment;
    }

    public String getShipmentNameTypeShipment() {
        return shipmentNameTypeShipment;
    }

    public Double getShipmentWidth() {
        return shipmentWidth;
    }

    public Double getShipmentDepth() {
        return shipmentDepth;
    }

    public Double getShipmentHeight() {
        return shipmentHeight;
    }

    public Double getShipmentWeight() {
        return shipmentWeight;
    }

    public String getShipmentCarMake() {
        return shipmentCarMake;
    }

    public String getShipmentCarModel() {
        return shipmentCarModel;
    }

    public String getShipmentCarYear() {
        return shipmentCarYear;
    }

    public String getShipmentCarOperational() {
        return shipmentCarOperational;
    }

    public Double getShipmentLooseVolume() {
        return shipmentLooseVolume;
    }

    public Double getShipmentLooseWeight() {
        return shipmentLooseWeight;
    }

    public Double getShipmentLiquidVolum() {
        return shipmentLiquidVolum;
    }

    public Double getShipmentLiquidWeight() {
        return shipmentLiquidWeight;
    }

    public int getShipmentLiquidPacked() {
        return shipmentLiquidPacked;
    }

    public Double getShipmentAgriculturalVolume() {
        return shipmentAgriculturalVolume;
    }

    public Double getShipmentAgriculturalWeight() {
        return shipmentAgriculturalWeight;
    }

    public int getShipmentAgriculturalPacked() {
        return shipmentAgriculturalPacked;
    }

    public String getShipmentAnimalsSize() {
        return shipmentAnimalsSize;
    }

    public Boolean getShipmentAnimalsCage() {
        return shipmentAnimalsCage;
    }

    public String[] getShipmentPhotos() {
        return shipmentPhotos;
    }

//    public void setShipmentRef(String shipmentRef) {
//
//        this.shipmentRef = shipmentRef;
//    }

    public void setShipmentKey(String shipmentKey) {
        this.shipmentKey = shipmentKey;
    }

    public void setOwnerUser(String ownerUser) {
        this.ownerUser = ownerUser;
    }

    public void setTipeStop(TypeStop tipeStop) {
        this.tipeStop = tipeStop;
    }

    public void setTypePackage(TypePackage typePackage) {
        this.typePackage = typePackage;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public void setShipmentLoad(Boolean shipmentLoad) {
        this.shipmentLoad = shipmentLoad;
    }

    public void setShipmentUnload(Boolean shipmentUnload) {
        this.shipmentUnload = shipmentUnload;
    }

    public void setShipmentQuantity(Double shipmentQuantity) {
        this.shipmentQuantity = shipmentQuantity;
    }

    public void setShipmentTitle(String shipmentTitle) {
        this.shipmentTitle = shipmentTitle;
    }

    public void setShipmentIndexTypeShipment(int shipmentIndexTypeShipment) {
        this.shipmentIndexTypeShipment = shipmentIndexTypeShipment;
    }

    public void setShipmentNameTypeShipment(String shipmentNameTypeShipment) {
        this.shipmentNameTypeShipment = shipmentNameTypeShipment;
    }

    public void setShipmentWidth(Double shipmentWidth) {
        this.shipmentWidth = shipmentWidth;
    }

    public void setShipmentDepth(Double shipmentDepth) {
        this.shipmentDepth = shipmentDepth;
    }

    public void setShipmentHeight(Double shipmentHeight) {
        this.shipmentHeight = shipmentHeight;
    }

    public void setShipmentWeight(Double shipmentWeight) {
        this.shipmentWeight = shipmentWeight;
    }

    public void setShipmentCarMake(String shipmentCarMake) {
        this.shipmentCarMake = shipmentCarMake;
    }

    public void setShipmentCarModel(String shipmentCarModel) {
        this.shipmentCarModel = shipmentCarModel;
    }

    public void setShipmentCarYear(String shipmentCarYear) {
        this.shipmentCarYear = shipmentCarYear;
    }

    public void setShipmentCarOperational(String shipmentCarOperational) {
        this.shipmentCarOperational = shipmentCarOperational;
    }

    public void setShipmentLooseVolume(Double shipmentLooseVolume) {
        this.shipmentLooseVolume = shipmentLooseVolume;
    }

    public void setShipmentLooseWeight(Double shipmentLooseWeight) {
        this.shipmentLooseWeight = shipmentLooseWeight;
    }

    public void setShipmentLiquidVolum(Double shipmentLiquidVolum) {
        this.shipmentLiquidVolum = shipmentLiquidVolum;
    }

    public void setShipmentLiquidWeight(Double shipmentLiquidWeight) {
        this.shipmentLiquidWeight = shipmentLiquidWeight;
    }

    public void setShipmentLiquidPacked(int shipmentLiquidPacked) {
        this.shipmentLiquidPacked = shipmentLiquidPacked;
    }

    public void setShipmentAgriculturalVolume(Double shipmentAgriculturalVolume) {
        this.shipmentAgriculturalVolume = shipmentAgriculturalVolume;
    }

    public void setShipmentAgriculturalWeight(Double shipmentAgriculturalWeight) {
        this.shipmentAgriculturalWeight = shipmentAgriculturalWeight;
    }

    public void setShipmentAgriculturalPacked(int shipmentAgriculturalPacked) {
        this.shipmentAgriculturalPacked = shipmentAgriculturalPacked;
    }

    public void setShipmentAnimalsSize(String shipmentAnimalsSize) {
        this.shipmentAnimalsSize = shipmentAnimalsSize;
    }

    public void setShipmentAnimalsCage(Boolean shipmentAnimalsCage) {
        this.shipmentAnimalsCage = shipmentAnimalsCage;
    }

    public void setShipmentPhotos(String[] shipmentPhotos) {
        this.shipmentPhotos = shipmentPhotos;
    }
}
