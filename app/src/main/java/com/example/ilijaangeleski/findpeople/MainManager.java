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
            if (isFirstNameNotNullAndInList(firstName, user)
                    && isLastNameNotNullAndInList(lastName, user)
                    && isCityNotNullAndInLIst(city, user)) {
                foundUser.add(user);
            } else if (isFirstNameNotNullAndInList(firstName, user)
                    && isLastNameNotNullAndInList(lastName, user)) {
                foundUser.add(user);
            } else if (isFirstNameNotNullAndInList(firstName, user)
                    && isCityNotNullAndInLIst(city, user)) {
                foundUser.add(user);
            } else if (isLastNameNotNullAndInList(lastName, user)
                    && isCityNotNullAndInLIst(city, user)) {
                foundUser.add(user);
            }else if(isFirstNameNotNullAndInList(firstName,user)){
                foundUser.add(user);
            }else if(isLastNameNotNullAndInList(lastName,user)){
                foundUser.add(user);
            }else if(isCityNotNullAndInLIst(city,user)){
                foundUser.add(user);
            }
        }

        return foundUser;
    }

    private boolean isCityNotNullAndInLIst(String city, User user) {
        return city != null
                && !city.equals("")
                && user.getCity().toLowerCase().startsWith(city.toLowerCase());
    }

    private boolean isLastNameNotNullAndInList(String lastName, User user) {
        return lastName != null
                && !lastName.equals("")
                && user.getLastName().toLowerCase().startsWith(lastName.toLowerCase());
    }

    private boolean isFirstNameNotNullAndInList(String firstName, User user) {
        return firstName != null
                && !firstName.equals("")
                && user.getFirstName().toLowerCase().startsWith(firstName.toLowerCase());
    }

    public boolean checkUserHasQuery(String firstName, String lastName, String city) {
        return (firstName == null || firstName.equals("")) &&
                (lastName == null || lastName.equals("")) &&
                (city == null || city.equals(""));
    }

    public List<User> getUsers() {
        return people;
    }
}

