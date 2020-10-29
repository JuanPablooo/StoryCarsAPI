package com.stor.car.resources;

import com.stor.car.entity.Profile;
import com.stor.car.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/profile")
public class ProfileResource {
    
    @Autowired
    private ProfileService profileService;

    @GetMapping("")
    public ResponseEntity<Page<Profile>> getAll(Pageable pageable){
        return new ResponseEntity<>(profileService.listProfiles(pageable), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Profile> getOne(@PathVariable Long id){
        return new ResponseEntity<>(profileService.findOneById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Profile> save(@RequestBody Profile profile){
        return new ResponseEntity<>(profileService.save(profile), HttpStatus.OK);
    }

    @PutMapping(value = {"", "/"})
    public ResponseEntity<Profile> update(@RequestBody Profile profile){
        return new ResponseEntity<>(profileService.update(profile), HttpStatus.OK);
    }
}
