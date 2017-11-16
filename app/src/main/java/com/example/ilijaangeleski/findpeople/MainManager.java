package com.example.ilijaangeleski.findpeople;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilija Angeleski on 11/16/2017.
 */

public class MainManager {

    public static final List<User> people = new ArrayList<>();

    static {
        people.add(new User("Ilija", "Angeleski", "Bitola"));
        people.add(new User("Iljo", "Angeloski", "Struga"));
        people.add(new User("Vljade", "Andzelovic", "Skopje"));
        people.add(new User("Pece", "Zdravko", "Sydney"));
        people.add(new User("Pecka", "Peckovski", "Skopje"));
        people.add(new User("Vladimir", "Angeleski", "Bitola"));
        people.add(new User("Paljo", "Zdravkovski", "Bitola"));
        people.add(new User("Pavle", "Pecakovski", "Ohrid"));
    }

    public List<User> findUser(String firstName, String lastName, String city) {
        List<User> foundUser = new ArrayList<>();
        if (firstName != "" && firstName != null || lastName != "" && lastName != null || city != "" && city != null) {
            for (User user : people) {
                for (User fuser : foundUser) {
                    if (firstName.contains(user.getFirstName()) && lastName.contains(user.getLastName()) && city.contains(user.getCity())) {
                        foundUser.add(fuser);
                    }
                }
            }
        }
        return foundUser;
    }
}

