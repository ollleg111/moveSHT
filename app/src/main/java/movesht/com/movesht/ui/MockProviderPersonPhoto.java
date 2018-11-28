package movesht.com.movesht.ui;

import java.util.ArrayList;
import java.util.List;

import movesht.com.movesht.R;
import movesht.com.movesht.model.Image;
import movesht.com.movesht.model.PersonType;

/**
 * Created by Admin on 04.04.2017.
 */

public class MockProviderPersonPhoto{

    List<PersonType> list = new ArrayList<>();

    public MockProviderPersonPhoto(){
        list.add(new PersonType(new Image(R.drawable.ic_animals_black)));
        list.add(new PersonType(new Image(R.drawable.ic_animals_black)));
        list.add(new PersonType(new Image(R.drawable.ic_animals_black)));
        list.add(new PersonType(new Image(R.drawable.ic_animals_black)));
        list.add(new PersonType(new Image(R.drawable.ic_animals_black)));
        list.add(new PersonType(new Image(R.drawable.ic_animals_black)));
        list.add(new PersonType(new Image(R.drawable.ic_animals_black)));

    }

    public List<PersonType> getPersonPhotoList() {
        return list;
    }
}