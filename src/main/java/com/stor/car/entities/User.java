package com.stor.car.entities;

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
