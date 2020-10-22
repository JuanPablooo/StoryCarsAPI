package com.stor.car.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity{

    @Column(unique = true)
    private String email;

    private String password;
}
