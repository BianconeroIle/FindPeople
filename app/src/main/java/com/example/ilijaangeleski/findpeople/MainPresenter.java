package com.example.ilijaangeleski.findpeople;
import java.util.List;

import static com.example.ilijaangeleski.findpeople.MainManager.people;

/**
 * Created by Ilija Angeleski on 11/16/2017.
 */

public class MainPresenter {
    MainManager mainManager;
    MainView view;

    public MainPresenter(MainView view) {
        mainManager = new MainManager();
        this.view = view;
    }
    public void onSearch(String firstName,String lastName,String city){
         view.update(mainManager.findUser(firstName, lastName, city));
    }

    public static List<User> getPeople() {
        return people;
    }
}
