package movesht.com.movesht.ui;

import java.util.List;

import movesht.com.movesht.interfaces.InterfaceRV;

/**
 * Created by Admin on 06.04.2017.
 */

public class MockContacts implements InterfaceRV {
    @Override
    public List getListUser() {

        MockUsers mockUsers = new MockUsers();
        return mockUsers.getUserList();
    }
}
