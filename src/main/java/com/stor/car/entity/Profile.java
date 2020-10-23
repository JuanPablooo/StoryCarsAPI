package com.stor.car.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.stor.car.entity.enums.TypeProfile;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Profile extends AbstractEntity{


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;

    private String thumbnail;

    @ElementCollection(fetch =  FetchType.EAGER)
    @CollectionTable(name = "type_profile")
    private Set<Integer> profileTypes = new HashSet<>();

    public Set<TypeProfile> getProfileTypes() {
        return profileTypes.stream().map(TypeProfile::toEnum).collect(Collectors.toSet());
    }

    public void add(TypeProfile typeProfile) {
        this.profileTypes.add(typeProfile.getId());
    }

    public Profile() {
        super();
        System.out.println("cobtruct");
        add(TypeProfile.USER);
    }
    public Profile(User user, String thumbnail, List<TypeProfile> typeProfiles){
        super();
        System.out.println("sddfsdf");
        add(TypeProfile.USER);
    }

}
