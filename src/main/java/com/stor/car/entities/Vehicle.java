package com.stor.car.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

//@Entityg
@Builder
@Data
public class Vehicle {
    private String name;
    private Image thumbnail;
    private String description;
    private int yearn;
    private double price;
    private String type;
}
