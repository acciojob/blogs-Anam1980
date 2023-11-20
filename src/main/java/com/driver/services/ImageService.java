package com.driver.services;

import com.driver.dto.ImageResponse;
import com.driver.models.*;
import com.driver.repositories.*;
import com.driver.transformer.ImageTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public ImageResponse addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setDescription(description);
        image.setDimension(dimensions);

        Optional<Blog> blogOptional = blogRepository2.findById(blogId);
        Blog blog = blogOptional.get();
        List<Image>images = blog.getImageList();
        images.add(image);

        blog.setImageList(images);

        blogRepository2.save(blog);

        imageRepository2.save(image);

        return ImageTransformer.ImageToImageResponse(image);


    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Optional<Blog> blogOptional = blogRepository2.findById(id);
        Blog blog = blogOptional.get();

        List<Image> images = blog.getImageList();

        int cnt=0;

        for(Image image : images){
            if(image.getDimension().equals(screenDimensions)){
                cnt++;
            }
        }
        return  cnt;
    }
}
