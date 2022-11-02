package com.codegym.blog.service;

import com.codegym.blog.model.MyUserDetail;
import com.codegym.blog.model.User;
import com.codegym.blog.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not found!");
        }
        return new MyUserDetail(user);
    }
}
