package com.stor.car.resources;

import com.stor.car.entity.Vehicle;
import com.stor.car.services.VehicleService;
import com.stor.car.uploads.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleResource {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleResource(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping("")
    public ResponseEntity<Page<Vehicle>> getAll(Pageable pageable){
        return new ResponseEntity<>(vehicleService.listVehicles(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getOne(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.findOneById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.save(vehicle), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Vehicle> update(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.update(vehicle), HttpStatus.OK);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<?> uploadImage(@PathVariable Long id,  @RequestBody FileUpload fileUpload){
        return new ResponseEntity<>(vehicleService.uploadImage(fileUpload, id), HttpStatus.OK);
    }

    @PostMapping("/{id}/thumbnail")
    public ResponseEntity<?> uploadThumbnail(@PathVariable Long id,  @RequestBody FileUpload fileUpload){
        return new ResponseEntity<>(vehicleService.uploadImage(fileUpload, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id){
        vehicleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
