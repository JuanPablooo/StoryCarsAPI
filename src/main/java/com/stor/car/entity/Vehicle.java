package com.stor.car.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
@Data
public class Vehicle extends AbstractEntity {

    private String name;

    private Image thumbnail;

    private String description;

    private String year;

    private Double price;

    private String type;
}
