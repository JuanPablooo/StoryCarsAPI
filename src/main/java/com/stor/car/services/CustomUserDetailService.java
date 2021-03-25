package com.stor.car.services;

import com.stor.car.entity.User;
import com.stor.car.repositories.UserRepository;
import com.stor.car.security.JWTUtil;
import com.stor.car.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository
                .findOneByEmail(username)
                .orElseThrow(()->  new UsernameNotFoundException("User not found by name" + username));

        return new UserPrincipal(user);
    }

    public String atualizaToken() {
        UserPrincipal user = UserService.userAutenticado();
        String token = jwtUtil.generateToken(user.getUsername());
        return UserService.getJsonToken(token, user.getUsername(), user.getId());
    }
}
