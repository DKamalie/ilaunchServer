package com.Ilaunch.Ilaunch.service;

import com.Ilaunch.Ilaunch.domain.User;

import java.util.Set;

public interface UserService extends IService<User, String>{
    User create(User user);
    User read(String userId);
    User update(User user);
    boolean delete(String userId);
    Set<User> getAll();
}
