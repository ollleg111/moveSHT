package movesht.com.movesht.ui;

import java.util.List;

import movesht.com.movesht.interfaces.InterfaceRV;

/**
 * Created by Admin on 07.04.2017.
 */

public class MockShipments implements InterfaceRV {

    @Override
    public List getListUser() {
        MockShipmentsExample mockShipmentsExample = new MockShipmentsExample();

        return mockShipmentsExample.getShipmentList();
    }
}
