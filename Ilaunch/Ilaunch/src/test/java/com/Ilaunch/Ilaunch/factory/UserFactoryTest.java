package com.Ilaunch.Ilaunch.factory;

import com.Ilaunch.Ilaunch.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserFactoryTest {

    @Test
    public void createUser() {
        User user = UserFactory.buildUser("David", "Brooks", "dave", "davidbrooks@gmail.com", true, "Administrator");
        System.out.println(user);
        assertNotNull(user);
    }
}
