package ru.dressyourkid.kidshop.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import ru.dressyourkid.kidshop.controller.exception.UploadException;
import ru.dressyourkid.kidshop.model.ImageDto;

import javax.annotation.PostConstruct;
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
                                    .width(360)
                                    .height(640)
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
