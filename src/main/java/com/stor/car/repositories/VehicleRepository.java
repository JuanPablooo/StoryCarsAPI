package com.stor.car.repositories;

import com.stor.car.entity.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends PagingAndSortingRepository<Vehicle, Long> {
}
