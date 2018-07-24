package ru.dressyourkid.kidshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by lconnected on 10/07/2018.
 */
@Entity
public class Discount {

    @Id
    @GeneratedValue
    private Long id;

    @Column(precision = 12, scale = 9)
    private BigDecimal percentage;

    @Column
    private String name;

    public Discount() {

    }

    public Discount(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
