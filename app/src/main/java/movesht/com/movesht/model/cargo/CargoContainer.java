package movesht.com.movesht.model.cargo;

import java.util.List;

/**
 * Created by PC on 07-Apr-17.
 */

public class CargoContainer {

    List<CargoType> cargoTypes;

    public void setCargoTypes(List<CargoType> cargoTypes) {
        this.cargoTypes = cargoTypes;
    }

    public List<CargoType> getCargoTypes() {
        return cargoTypes;
    }
}
