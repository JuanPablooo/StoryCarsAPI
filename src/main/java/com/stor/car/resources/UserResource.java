package com.stor.car.resources;

import com.stor.car.entity.User;
import com.stor.car.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/v1/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<Page<User>> getAll(Pageable pageable){
        return new ResponseEntity<>(userService.listUsers(pageable), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<User> getOne(@PathVariable Long id){
        return new ResponseEntity<>(userService.findOneById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @PutMapping(value = {"", "/"})
    public ResponseEntity<User> update(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

}
