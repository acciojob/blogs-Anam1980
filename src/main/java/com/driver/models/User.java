package com.driver.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String username;

    String password;

    String firstName;

    String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Blog>blogList = new ArrayList<>();
}