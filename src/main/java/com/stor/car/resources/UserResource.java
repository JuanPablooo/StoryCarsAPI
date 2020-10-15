package com.stor.car.resources;

import com.stor.car.entity.User;
import com.stor.car.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<User> getOne(@PathVariable Long id){
        return new ResponseEntity<>(userService.findOneById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<User> save(@RequestBody User user){
        System.out.println("salve");
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

//    @PutMapping(value = {"", "/"})
//    public ResponseEntity<User> update(@RequestBody User user){
//        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
//    }

}
