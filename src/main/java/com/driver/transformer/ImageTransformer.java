package com.driver.transformer;

import com.driver.dto.ImageResponse;
import com.driver.models.Image;

public class ImageTransformer {
    public static ImageResponse ImageToImageResponse(Image image) {
        return ImageResponse.builder()
                .description(image.getDescription())
                .dimension(image.getDimension())
                .build();
    }
}
