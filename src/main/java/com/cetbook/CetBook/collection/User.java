package com.cetbook.CetBook.collection;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id
    int userId;
    String username;
    String phone;
    String password;
    int age;
    String branch;
    String year;
    String bio;
    List<String> interests;
    List<User> my_likes;
    List<User> mutual_likes;
}
