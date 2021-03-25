package com.stor.car.entity;

import com.stor.car.entity.enums.TypeProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity{

    @Column(unique = true)
    private String email;

    private String password;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Profile profile;

    @ElementCollection(fetch =  FetchType.EAGER)
    @CollectionTable(name = "type_profile")
    private Set<Integer> profileTypes = new HashSet<>();

    public Set<TypeProfile> getProfileTypes() {
        return profileTypes.stream().map(TypeProfile::toEnum).collect(Collectors.toSet());
    }

    public void add(TypeProfile typeProfile) {
        this.profileTypes.add(typeProfile.getId());
    }
}
