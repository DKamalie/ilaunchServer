package com.Ilaunch.Ilaunch.serviceImpl;

import com.Ilaunch.Ilaunch.domain.User;
import com.Ilaunch.Ilaunch.factory.UserFactory;
import com.Ilaunch.Ilaunch.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl service;
    private static User user = UserFactory.buildUser("David", "Brooks", "dave", "davidbrooks@gmail.com", true, "Administrator");

    @Test
    public void a_create() {
        User create1 = service.create(user);
        System.out.println(create1);
        assertNotNull(create1);
    }

    @Test
    public void b_read(){
        User read1 = service.read(String.valueOf(user.getUserId()));
        System.out.println(read1);
        assertNotNull(read1);
    }

    @Test
    public void c_update() {
        User updated = new User.Builder().copy(user).setName("Updated Name").build();
        assertNotNull(service.update(updated));
        System.out.println(updated);
    }
    @Test
    public void d_getAll(){
        System.out.println(service.getAll());
    }

    @Test
    public void e_delete(){
        boolean deleted = service.delete(String.valueOf(user.getUserId()));
        assertTrue(deleted);
        System.out.println(true + " = deleted");
    }


}
