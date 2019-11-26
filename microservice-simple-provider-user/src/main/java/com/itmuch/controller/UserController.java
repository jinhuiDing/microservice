package com.itmuch.controller;

import com.itmuch.dao.UserRepository;
import com.itmuch.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
        System.out.println("port= 8000" );
        return userRepository.findOne(id);
    }

    @GetMapping("get0")
    public User get0(User user){
        return userRepository.findOne(user.getId());
    }
    @GetMapping("get1")
    public User get1(@RequestParam HashMap map){
        return userRepository.findOne(Long.parseLong(map.get("id").toString()));
    }


    @RequestMapping(method = RequestMethod.POST,value = "post")
    public User post(@RequestBody User user){
        System.out.println("user = " + user);
        return userRepository.findOne(user.getId());
    }
}
