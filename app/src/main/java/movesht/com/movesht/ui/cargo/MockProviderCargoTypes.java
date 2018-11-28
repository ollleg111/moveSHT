package movesht.com.movesht.ui.cargo;

import java.util.ArrayList;
import java.util.List;

import movesht.com.movesht.R;
import movesht.com.movesht.model.Image;
import movesht.com.movesht.model.cargo.CargoType;

public class MockProviderCargoTypes {
    List<CargoType> list = new ArrayList<>();

    public MockProviderCargoTypes() {
        list.add(new CargoType(new Image(R.drawable.ic_cars_black), "Cars"));
        list.add(new CargoType(new Image(R.drawable.ic_home_black), "Home"));
        list.add(new CargoType(new Image(R.drawable.ic_liquid_black), "Liquid"));
        list.add(new CargoType(new Image(R.drawable.ic_loose_black), "Loose"));
        list.add(new CargoType(new Image(R.drawable.ic_animals_black), "Animals"));
        list.add(new CargoType(new Image(R.drawable.ic_agricultural_black), "Agricultural"));
        list.add(new CargoType(new Image(R.drawable.ic_garbage_black), "Garbage"));
        list.add(new CargoType(new Image(R.drawable.ic_food_black), "Food"));
        list.add(new CargoType(new Image(R.drawable.ic_people_black), "People"));
        list.add(new CargoType(new Image(R.drawable.ic_construction_black), "Construction"));
    }

    public List<CargoType> getCargoList() {
        return list;
    }
}
