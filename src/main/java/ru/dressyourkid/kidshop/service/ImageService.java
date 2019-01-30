package ru.dressyourkid.kidshop.service;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import com.cloudinary.*;
import ru.dressyourkid.kidshop.controller.exception.UploadException;
import ru.dressyourkid.kidshop.model.ImageDto;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageService {

    private Cloudinary cloudinary;

    @PostConstruct
    public void init() {
        this.cloudinary = new Cloudinary();
    }

    public ImageDto uploadHD(Object image) throws UploadException {
        try {
            Map uploadResponse = cloudinary.uploader().upload(image,
                    ObjectUtils.asMap("transformation",
                            new Transformation()
                                    .crop("limit")
                                    .width(1920)
                                    .height(1080)
                    )
            );
            // create image link in db
            // secure_url, created_at, url, tags?, width?, height?
            return new ImageDto(
                    (String) uploadResponse.get("url"),
                    (String) uploadResponse.get("secure_url")
            );
        } catch (IOException e) {
            e.printStackTrace();
            throw new UploadException(e);
        }
    }

}
