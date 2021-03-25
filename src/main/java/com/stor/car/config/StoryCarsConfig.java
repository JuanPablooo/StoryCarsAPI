package com.stor.car.config;

import com.stor.car.security.JWTAuthenticationFilter;
import com.stor.car.security.JWTUtil;
import com.stor.car.security.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StoryCarsConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    private final String[] PUBLIC_ROUTS = {
            "/vehicle"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(PUBLIC_ROUTS).hasRole("ADMIN")
                .antMatchers("/*").authenticated()
                .and()
                .httpBasic();
        http.addFilter( new JWTAuthenticationFilter(authenticationManager(), jwtUtil ));
        http.addFilter( new JwtAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService ));
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
}
