package com.cetbook.CetBook.controller;

import com.cetbook.CetBook.collection.User;
import com.cetbook.CetBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String show(){
        return "hello";
    }

    @PostMapping("/register")
    public User saveUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }
    @PatchMapping("/liked/{userId}/{likedUserId}")
    public List<User> myLiked(@PathVariable String userId, @PathVariable String likedUserId){
        return userService.updateMyLikes(userId,likedUserId);
    }

}
