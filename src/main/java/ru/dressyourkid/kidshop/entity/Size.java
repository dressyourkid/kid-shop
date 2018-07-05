package ru.dressyourkid.kidshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lconnected on 04/07/2018.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private long size;

    @Column
    private double price;

    @Column
    private int amount;

    @Column
    private double discount;


}
