package ru.dressyourkid.kidshop.model;

/**
 * DTO for single image
 */
public class ImageDto {

    private String url;
    private String secureUrl;

    public ImageDto() {
    }

    public ImageDto(String url, String secureUrl) {
        this.url = url;
        this.secureUrl = secureUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecureUrl() {
        return secureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        this.secureUrl = secureUrl;
    }
}
