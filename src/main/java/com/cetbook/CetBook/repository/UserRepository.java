package com.cetbook.CetBook.repository;

import com.cetbook.CetBook.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    void deleteById(String id);
}
