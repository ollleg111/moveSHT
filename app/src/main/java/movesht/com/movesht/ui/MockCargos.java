package movesht.com.movesht.ui;

import java.util.List;

import movesht.com.movesht.interfaces.InterfaceRV;
import movesht.com.movesht.ui.cargo.MockProviderCargoTypes;

/**
 * Created by Admin on 06.04.2017.
 */

public class MockCargos implements InterfaceRV {
    @Override
    public List getListUser() {

        MockProviderCargoTypes mockProviderCargoTypes = new MockProviderCargoTypes();

        return mockProviderCargoTypes.getCargoList();
    }
}
