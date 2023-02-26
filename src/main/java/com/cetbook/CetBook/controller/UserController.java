package com.cetbook.CetBook.controller;

import com.cetbook.CetBook.collection.User;
import com.cetbook.CetBook.response.UserResponseHandler;
import com.cetbook.CetBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String show(){
        return "hello";
    }
    
    @GetMapping("/users/{userId}")
    public ResponseEntity<Object> getUsers(@PathVariable String userId){
    	return UserResponseHandler.userResponseBuilder("Request successful", HttpStatus.OK, userService.getAllUsers(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<Object> saveUser(@RequestBody User user){
        return UserResponseHandler.userResponseBuilder("User added successfully", HttpStatus.OK, userService.saveUser(user));
    }
    @PatchMapping("/liked/{userId}/{likedUserId}")
    public ResponseEntity<Object> myLiked(@PathVariable String userId, @PathVariable String likedUserId){
//        return userService.updateMyLikes(userId,likedUserId);
        return UserResponseHandler.userResponseBuilder("User matched Successfully", HttpStatus.OK, userService.updateMyLikes(userId,likedUserId));
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        if(userService.deleteUser(id)){
            return "User Deleted Successfully";
        }
        else{
            return "User not found or not deleted";
        }

}

}
