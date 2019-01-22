package ru.dressyourkid.kidshop.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность описания товара (общая информация)
 */
@Entity
@Table(indexes = {
        @Index(name = "search_index", columnList = "name,description")
})
public class ProductMeta {

    @Id
    @GeneratedValue
    private Long id;

    @Column()
    private String name;

    @Column
    private String description;

    @ManyToOne
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
