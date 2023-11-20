package com.driver.transformer;

import com.driver.dto.UserResponse;
import com.driver.models.User;

public class UserTransformer {
    public static UserResponse UserToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .blogList(user.getBlogList())
                .build();
    }
}
