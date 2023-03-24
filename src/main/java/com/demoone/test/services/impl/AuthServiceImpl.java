package com.demoone.test.services.impl;

import com.demoone.test.exception.CustomException;
import com.demoone.test.model.dto.LoginDto;
import com.demoone.test.model.dto.RegisterDto;
import com.demoone.test.model.entity.Role;
import com.demoone.test.model.entity.User;
import com.demoone.test.repository.RoleRepository;
import com.demoone.test.repository.UserRepository;
import com.demoone.test.security.JwtTokenProvider;
import com.demoone.test.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @Override
    public String register(RegisterDto registerDto) {
        User newUser = new User();
        newUser.setName(registerDto.getName());
        newUser.setUsername(registerDto.getUsername());
        newUser.setEmail(registerDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerDto.getPassword()));

//        List<Role> roles = new ArrayList<>();
//        Role userRole = roleRepository.findByName("normal").get();
//        System.out.println("Check userRole: " + userRole);
//        if(Objects.nonNull(userRole)){
//            roles.add(userRole);
//            System.out.println("Run if !!!");
//            User.setRoles(roles);
//        }else {
//            System.out.println("Run else !!!");
//            userRole.setName("normal");
//            userRole.setDescription("Normal user");
//            roles.add(userRole);
//            User.setRoles(roles);
//        }
//        userRepository.save(User);


        List<Role> test = roleRepository.findAllById(registerDto.getRoleIds());

        newUser.setRoles(test);
        userRepository.save(newUser);

        return "User registered successfully!.";
    }

    @Override
    public String login(LoginDto loginDto) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
            return jwtTokenProvider.createToken(loginDto.getUsername(), userRepository.findByUsername(loginDto.getUsername()).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
