package com.codegym.blog.repository;

import com.codegym.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String name);
}
