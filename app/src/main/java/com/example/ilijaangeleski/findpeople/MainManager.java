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
            for (User user : people) {
                    if (firstName != null && !firstName.equals(" ")&& user.getFirstName().toLowerCase().contains(firstName)){
                        foundUser.add(user);
                    }
                }
            return foundUser;
        }


    public List<User> getUsers(){
        return people;
    }
}

