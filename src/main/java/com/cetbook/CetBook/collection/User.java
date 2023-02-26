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
    String userId;
    String username;
    String phone;
    String password;
    String profilePic;
    int age;
    String branch;
    String year;
    String bio;
    List<String> interests;
    List<String> my_likes;
    List<String> mutual_likes;
}
