package com.driver.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String title;

    String content;

    Date pubDate;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    List<Image> imageList = new ArrayList<>();


}