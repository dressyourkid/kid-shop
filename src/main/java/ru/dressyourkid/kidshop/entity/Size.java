package ru.dressyourkid.kidshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Сущность - справочник размеров
 */
@Entity
public class Size {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Название размера (S, M, L и др.)
     */
    @Column
    private String name;

    /**
     * Ширина в миллиметрах
     */
    @Column
    private Long width;

    /**
     * Длина в миллиметрах
     */
    @Column
    private Long height;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }
}
