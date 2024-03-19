package com.Ilaunch.Ilaunch.service.impl;

import com.Ilaunch.Ilaunch.domain.User;
import com.Ilaunch.Ilaunch.repository.IUserRepository;
import com.Ilaunch.Ilaunch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final IUserRepository userRepository;
    @Autowired
    private  UserServiceImpl(IUserRepository userRepo) {this.userRepository = userRepo;}

    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User read(String userId) {
        return this.userRepository.findById(userId).orElse(null);
    }

    @Override
    public User update(User user) {
        if (this.userRepository.existsById(String.valueOf(user.getUserId()))) {
            return this.userRepository.save(user);
        }else {
            return null;
        }
    }

    @Override
    public boolean delete(String userId) {
        if (this.userRepository.existsById(userId)) {
            this.userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public Set<User> getAll() {
        return this.userRepository.findAll().stream().collect(Collectors.toSet());
    }
}
