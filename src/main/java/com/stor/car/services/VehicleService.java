package com.stor.car.services;

import com.stor.car.entity.Image;
import com.stor.car.entity.Vehicle;
import com.stor.car.repositories.VehicleRepository;
import com.stor.car.uploads.FileUpload;
import com.stor.car.uploads.FileUploadUrl;
import com.stor.car.uploads.FireBaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final FireBaseStorageService fireBase;
    private static final String  URL_FOLDER = "story-cars/vehicle/";
    private static final String  MIME_TYPE_IMG = "image/png";

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, FireBaseStorageService fireBase) {
        this.vehicleRepository = vehicleRepository;
        this.fireBase = fireBase;

    }

    public Page<Vehicle> getVehiclesPageable(Pageable pageable){
        return vehicleRepository.findAll(pageable);
    }

    public List<Vehicle> getAllVehiclesNoPageable(){
        return vehicleRepository.findAll();
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

    public FileUploadUrl uploadImageThumbnailToVehicle(FileUpload file, Long id) {
        Vehicle vehicle = getByIdOrThrow(id);
        FileUploadUrl fileUploadUrl = uploadImage(file);
        vehicle.setThumbnail(fileUploadUrl.getUrl());
        vehicleRepository.save(vehicle);
        return fileUploadUrl;
    }

    public FileUploadUrl uploadImageToVehicle(FileUpload file, Long id) {
        Vehicle vehicle = getByIdOrThrow(id);

        FileUploadUrl fileUploadUrl = uploadImage(file);
        String url = fileUploadUrl.getUrl();
        Image image = Image.builder().url( url ).build();
        vehicle.getImages().add(image);

        vehicleRepository.save(vehicle);
        return fileUploadUrl;
    }

    public FileUploadUrl uploadImage(FileUpload file) {
        FileUploadUrl fileUploadUrl = creteNameImageAndMakeUpload(file);
        file.setMimeType(MIME_TYPE_IMG);
        return fileUploadUrl ;
    }

    private FileUploadUrl creteNameImageAndMakeUpload(FileUpload file){
        String name =  URL_FOLDER + System.currentTimeMillis();
        return new FileUploadUrl(fireBase.uploadFileBase4(file, name));
    }

    public void deleteById(Long id){
        getByIdOrThrow(id);
        vehicleRepository.deleteById(id);
    }

    private Vehicle getByIdOrThrow(Long id){
        return  vehicleRepository.findById(id)
                .orElseThrow(null);
    }
}
