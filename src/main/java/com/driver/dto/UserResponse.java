package com.driver.dto;

import com.driver.models.Blog;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class UserResponse {
    int id;

    String username;

    String password;

    String firstName;

    String lastName;

    List<Blog> blogList;
}

