package com.Ilaunch.Ilaunch.factory;

import com.Ilaunch.Ilaunch.domain.User;
import com.Ilaunch.Ilaunch.util.Helper;

public class UserFactory {
    public static User buildUser(String name, String surname, String username, String email, boolean active, String role) {
        if(Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname) || Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(role)) {
            return null;
        }
        String userID = Helper.generateId();
        User user = new User.Builder().setUserID(userID).setName(name).setSurname(surname).setUsername(username).setEmail(email).setActive(false).setRole("Administrator").build();
        return user;
    }
}
