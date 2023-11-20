package com.driver.transformer;

import com.driver.dto.BlogResponse;
import com.driver.models.Blog;

public class BlogTranformer {
    public static BlogResponse blogToBlogResponse(Blog blog) {
        return BlogResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .build();
    }
}
