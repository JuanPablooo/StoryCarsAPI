package com.stor.car.entity;

import lombok.Builder;
import lombok.Data;

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
