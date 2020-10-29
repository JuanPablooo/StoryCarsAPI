package com.stor.car.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle extends AbstractEntity {

    private String name;

    private String thumbnail;

    private String description;

    private String year;

    private Double price;

    private String type;
}
