package com.cetbook.CetBook.service;

import com.cetbook.CetBook.collection.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser (User user);

    List<User> updateMyLikes(String userId, String likedUserId);
}
