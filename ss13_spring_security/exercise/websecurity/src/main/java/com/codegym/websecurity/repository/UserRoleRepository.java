package com.codegym.websecurity.repository;

import com.codegym.websecurity.entity.AppRole;
import com.codegym.websecurity.entity.AppUser;
import com.codegym.websecurity.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
