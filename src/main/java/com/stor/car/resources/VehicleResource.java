package com.stor.car.resources;

import com.stor.car.entity.Vehicle;
import com.stor.car.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vehicle")
public class VehicleResource {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("")
    public ResponseEntity<Page<Vehicle>> getAll(Pageable pageable){
        return new ResponseEntity<>(vehicleService.listVehicles(pageable), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Vehicle> getOne(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.findOneById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.OK);
    }

    @PutMapping(value = {"", "/"})
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.update(vehicle), HttpStatus.OK);
    }
}
