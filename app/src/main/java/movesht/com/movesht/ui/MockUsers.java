package movesht.com.movesht.ui;

import java.util.ArrayList;
import java.util.List;

import movesht.com.movesht.model.User;

/**
 * Created by Admin on 05.04.2017.
 */

public class MockUsers  {

    List<User> list = new ArrayList<>();
    public MockUsers(){

        list.add(new User("Sergey","Schnurov"));
        list.add(new User("Jack","Daniels"));
        list.add(new User("Yura","Sokol"));
        list.add(new User("Ivan","Smirnoff"));
        list.add(new User("Marty","MacFly"));
        list.add(new User("Tony","Stark"));
        list.add(new User("John","Doe"));
        list.add(new User("Sergey","Milakov"));
        list.add(new User("Evgen","Solodilov"));
    }

    public List<User> getUserList() {
        return list;
    }
}
