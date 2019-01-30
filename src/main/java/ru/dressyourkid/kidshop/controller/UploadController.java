package ru.dressyourkid.kidshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.dressyourkid.kidshop.controller.exception.UploadException;
import ru.dressyourkid.kidshop.model.ImageDto;
import ru.dressyourkid.kidshop.service.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ImageDto uploadImage(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException, UploadException {
        // todo check files is images
        return imageService.uploadHD(file.getBytes());
    }

}
