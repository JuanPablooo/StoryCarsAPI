package com.stor.car.services;

import com.stor.car.entity.Vehicle;
import com.stor.car.repositories.VehicleRepository;
import com.stor.car.uploads.FileUpload;
import com.stor.car.uploads.FileUploadUrl;
import com.stor.car.uploads.FireBaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final FireBaseStorageService fireBase;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, FireBaseStorageService fireBase) {
        this.vehicleRepository = vehicleRepository;
        this.fireBase = fireBase;

    }

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
                .orElseThrow(null);
    }

    public FileUploadUrl uploadImage(FileUpload file, Long id) {
        Vehicle vehicle = getByIdOrThrow(id);
        //TODO refactor strategy of generate random name  to image
        FileUploadUrl url = fazIUploadArquivo(file);
        vehicle.setThumbnail(url.getUrl());
        vehicleRepository.save(vehicle);
        return url;
    }
    //TODO create service image and move this method
    public FileUploadUrl fazIUploadArquivo (FileUpload file){
        String name =  System.currentTimeMillis() + "";
        return new FileUploadUrl(fireBase.upLoad(file, name));
    }

    public void deleteById(Long id){
        getByIdOrThrow(id);
        vehicleRepository.deleteById(id);
    }
}
