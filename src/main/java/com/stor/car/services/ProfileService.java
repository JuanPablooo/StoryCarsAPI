//package com.stor.car.services;
//
//import com.stor.car.entity.Profile;
//import com.stor.car.repositories.ProfileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProfileService {
//
//    @Autowired
//    private ProfileRepository profileRepository;
//
//    public Page<Profile> listProfiles(Pageable pageable){
//        return profileRepository.findAll(pageable);
//    }
//
//    public Profile findOneById(Long id){
//        return getById(id);
//    }
//
//    public Profile save(Profile profile){
//
//        return profileRepository.save(profile);
//    }
//
//    public Profile update(Profile profile){
//        getByIdOrThrow(profile.getId());
//        return profileRepository.save(profile);
//    }
//
//    private Profile getById(Long id) {
//        return getByIdOrThrow(id);
//    }
//
//    private Profile getByIdOrThrow(Long id){
//        return  profileRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("profile not founded by id " + id));
//    }
//}
