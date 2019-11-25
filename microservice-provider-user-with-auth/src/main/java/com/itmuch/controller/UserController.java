package com.itmuch.controller;

import com.itmuch.dao.UserRepository;
import com.itmuch.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @description: UserController
 * @author: ding
 * @date: 2019/11/5 20:08
 * @version: 1.0
 */


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails userDetails=(UserDetails) principal;
            Collection<? extends GrantedAuthority> collection = userDetails.getAuthorities();
            for (GrantedAuthority grantedAuthority : collection) {
                System.out.println("grantedAuthority.getAuthority() = " + grantedAuthority.getAuthority());
                System.out.println("userDetails = " + userDetails.getUsername());
            }
        }
        return userRepository.findOne(id);
    }
}
