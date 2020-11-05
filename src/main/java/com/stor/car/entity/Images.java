package com.stor.car.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Images extends AbstractEntity {
    private String url;

}
