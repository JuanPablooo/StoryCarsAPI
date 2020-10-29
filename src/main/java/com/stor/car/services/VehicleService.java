package com.stor.car.services;

import com.stor.car.entity.Vehicle;
import com.stor.car.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository vehicleRepository;

    public Page<Vehicle> listVehicles(Pageable pageable){
        return vehicleRepository.findAll(pageable);
    }

    public Vehicle findOneById(Long id){
        return getById(id);
    }

    public Vehicle save(Vehicle vehicle){

        return vehicleRepository.save(vehicle);
    }

    public Vehicle update(Vehicle vehicle){
        getByIdOrThrow(vehicle.getId());
        return vehicleRepository.save(vehicle);
    }

    private Vehicle getById(Long id) {
        return getByIdOrThrow(id);
    }

    private Vehicle getByIdOrThrow(Long id){
        return  vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("vehicle not founded by id " + id));
    }
}
