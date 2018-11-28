package movesht.com.movesht.ui;

import java.util.List;

import movesht.com.movesht.interfaces.InterfaceRV;

/**
 * Created by user on 14.04.2017.
 */

public class MockPhotos implements InterfaceRV {

    @Override
    public List getListUser() {
        MockProviderPersonPhoto mockProviderPersonPhoto = new MockProviderPersonPhoto();

        return mockProviderPersonPhoto.getPersonPhotoList();    }
}
