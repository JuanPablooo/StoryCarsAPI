package com.stor.car.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Vehicle extends AbstractEntity {

    private String name;

    private String thumbnail;

    private String description;

    private String year;

    private BigDecimal price;

    private String type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "image_vehicle",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> images = new ArrayList<>();

}
