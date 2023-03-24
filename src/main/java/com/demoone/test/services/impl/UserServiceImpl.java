package com.demoone.test.services.impl;

import com.demoone.test.model.entity.User;
import com.demoone.test.repository.UserRepository;
import com.demoone.test.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
