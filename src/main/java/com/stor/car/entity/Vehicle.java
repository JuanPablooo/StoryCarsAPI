package com.stor.car.entity;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@Builder
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

}
