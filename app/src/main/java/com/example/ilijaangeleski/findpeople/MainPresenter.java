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

    public void onSearch(String firstName, String lastName, String city) {
        List<User> found = mainManager.findUser(firstName, lastName, city);
        view.update(found);
        if (mainManager.checkUserHasQuery(firstName, lastName, city)) {
            view.update(people);
            
        }
    }

    public List<User> getUsers() {
        return people;
    }
}
