package com.stor.car.services;

import com.stor.car.entity.User;
import com.stor.car.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> listUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User findOneById(Long id){
        return getById(id);
    }

    public User save(User user){

        return userRepository.save(user);
    }

    public User update(User user){
        getById(user.getId());
        return userRepository.save(user);
    }

    private User getById(Long id){
        Optional<User> userOpt = userRepository.findById(id);
//        return  userOpt.orElseThrow();
        return null;
    }
}
