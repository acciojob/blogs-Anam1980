package com.driver.services;

import com.driver.dto.UserResponse;
import com.driver.models.*;
import com.driver.repositories.UserRepository;
import com.driver.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public UserResponse createUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName("test");
        user.setLastName("test");

        userRepository3.save(user);

        return UserTransformer.UserToUserResponse(user);

    }

    public void deleteUser(int userId){
         userRepository3.deleteById(userId);
    }

    public UserResponse updateUser(Integer id, String password){
        Optional<User> userOptional = userRepository3.findById(id);

        User user = userOptional.get();
        user.setPassword(password);

        userRepository3.save(user);

        return  UserTransformer.UserToUserResponse(user);
    }
}
