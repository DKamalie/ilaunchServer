package com.Ilaunch.Ilaunch.repository;

import com.Ilaunch.Ilaunch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {
}
