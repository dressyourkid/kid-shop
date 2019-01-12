package ru.dressyourkid.kidshop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность описания товара (общая информация)
 */
@Entity
public class ProductMeta {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
