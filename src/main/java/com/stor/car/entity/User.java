package com.stor.car.entity;

import lombok.*;

import javax.persistence.Entity;

@Data
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity{
    private String email;
    private String password;
}
