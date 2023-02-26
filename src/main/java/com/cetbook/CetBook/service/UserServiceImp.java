package com.cetbook.CetBook.service;

import com.cetbook.CetBook.collection.User;
import com.cetbook.CetBook.exception.UserNotFoundException;
import com.cetbook.CetBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> updateMyLikes(String userId, String likedUserId) {
        User user1 = userRepository.findById(userId).get();
        User user2 = userRepository.findById(likedUserId).get();


        if (!(user2.getMy_likes().contains(userId))) {
            user1.getMy_likes().add(likedUserId);
            user1.setMy_likes(user1.getMy_likes());
            userRepository.save(user1);
        } else {
            user1.getMutual_likes().add(likedUserId);
            user2.getMutual_likes().add(userId);
            user1.setMutual_likes(user1.getMutual_likes());
            user2.setMutual_likes(user2.getMutual_likes());
            user2.getMy_likes().remove(userId);
            user2.setMy_likes(user2.getMy_likes());
            userRepository.save(user1);
            userRepository.save(user2);
        }
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        return list;
    }

    @Override
    public List<User> getAllUsers(String userId) {
        if (userRepository.findAll().isEmpty()) {
            throw new UserNotFoundException("User does not exist");
        }
        List<User> usersExceptCurrentUser = userRepository.findAll();
        usersExceptCurrentUser.remove(userRepository.findById(userId).get());
        return usersExceptCurrentUser;
    }

    @Override
    public boolean deleteUser(String id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("User does not exist");
        }
        userRepository.deleteById(id);
        return true;
    }

}
