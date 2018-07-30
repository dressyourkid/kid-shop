package ru.dressyourkid.kidshop.model;

/**
 * DTO for single product view
 */
public class SizeDto {

    private String name;

    public SizeDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
