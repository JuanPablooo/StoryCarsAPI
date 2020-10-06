package com.stor.car.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Entity
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
