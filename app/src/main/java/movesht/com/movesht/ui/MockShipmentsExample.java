package movesht.com.movesht.ui;

import java.util.ArrayList;
import java.util.List;

import movesht.com.movesht.model.MyShipment;

/**
 * Created by Admin on 07.04.2017.
 */

public class MockShipmentsExample {
    List<MyShipment> list = new ArrayList<>();

    public MockShipmentsExample() {
        list.add(new MyShipment(0.56,(double)100,(double)250,"Shipment Title 1"));
        list.add(new MyShipment((double) 22,(double)100,(double)250,"Shipment Title 2"));
        list.add(new MyShipment(23.1,(double)100,(double)250,"Shipment Title 3"));
        list.add(new MyShipment(0.2,(double)100,(double)250,"Shipment Title 4"));
        list.add(new MyShipment(63.2,(double)100,(double)250,"Shipment Title 5"));
        list.add(new MyShipment((double) 37,(double)100,(double)250,"Shipment Title 6"));
        list.add(new MyShipment(152.3,(double)100,(double)250,"Shipment Title 7"));
        list.add(new MyShipment((double) 225,(double)100,(double)250,"Shipment Title 8"));
        list.add(new MyShipment(2.9,(double)100,(double)250,"Shipment Title 9"));
        list.add(new MyShipment(75.6,(double)100,(double)250,"Shipment Title 10"));
        list.add(new MyShipment(44.1,(double)100,(double)250,"Shipment Title 11"));
        list.add(new MyShipment((double) 6,(double)100,(double)250,"Shipment Title 12"));

    }

    public List<MyShipment> getShipmentList() {
        return list;
    }
}
