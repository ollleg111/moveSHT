package movesht.com.movesht.ui;

import java.util.List;

import movesht.com.movesht.interfaces.InterfaceRV;
import movesht.com.movesht.model.cargo.CargoContainer;

/**
 * Created by user on 12.04.2017.
 */

public class MockCargosFB implements InterfaceRV {
    @Override
    public List getListUser() {

        CargoContainer cargoContainer = new CargoContainer();

        return cargoContainer.getCargoTypes();

    }
}