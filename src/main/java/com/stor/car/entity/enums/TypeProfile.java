package com.stor.car.entity.enums;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;

//@Data
@Getter
public enum TypeProfile {

    ADMIN(1, "ROLE_ADMIN"),
    USER(1, "ROLE_USER");

    private final int id;
    private final String describe;

    TypeProfile(int id, String describe) {
        this.id = id;
        this.describe = describe;
    }

    public static TypeProfile toEnum(Integer id){
        if(id == null ) return null;
        for (TypeProfile profile : TypeProfile.values()) {
            if( id.equals( profile.getId() ) ) return profile;
        }
        throw new IllegalArgumentException("Id invalid " + id);
    }
}
