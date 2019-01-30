package ru.dressyourkid.kidshop.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * DTO for single image
 */
public class ImageDto {

    private String url;
    private String secure_url;

    public ImageDto() {
    }

    public ImageDto(String url, String secure_url) {
        this.url = url;
        this.secure_url = secure_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecure_url() {
        return secure_url;
    }

    public void setSecure_url(String secure_url) {
        this.secure_url = secure_url;
    }
}
