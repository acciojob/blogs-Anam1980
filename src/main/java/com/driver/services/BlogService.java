package com.driver.services;

import com.driver.dto.BlogResponse;
import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import com.driver.transformer.BlogTranformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public BlogResponse createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Optional<User> userOptional = userRepository1.findById(userId);
       User user = userOptional.get();

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPubDate(new Date());

        List<Blog> blogList = user.getBlogList();
        blogList.add(blog);
        user.setBlogList(blogList);

        blogRepository1.save(blog);

        return BlogTranformer.blogToBlogResponse(blog);
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Optional<Blog> blogOptional = blogRepository1.findById(blogId);

        Blog blog = blogOptional.get();

        List<Image>images = blog.getImageList();
        images.clear();
        blog.setImageList(images);

        blogRepository1.deleteById(blogId);


    }
}
