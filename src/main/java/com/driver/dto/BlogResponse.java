package com.driver.dto;

import com.driver.models.Image;
import com.driver.models.User;
import lombok.Builder;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
public class BlogResponse {

    int id;

    String title;

    String content;

    Date pubDate;


}
