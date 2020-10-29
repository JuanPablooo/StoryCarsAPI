package com.stor.car.repositories;

import com.stor.car.entity.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long> {
}
