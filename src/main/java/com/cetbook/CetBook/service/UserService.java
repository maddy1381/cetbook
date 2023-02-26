package com.cetbook.CetBook.service;

import com.cetbook.CetBook.collection.User;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser (User user);

    List<User> updateMyLikes(String userId, String likedUserId);
	List<User> getAllUsers(String userId);

    boolean deleteUser(String id);
}
