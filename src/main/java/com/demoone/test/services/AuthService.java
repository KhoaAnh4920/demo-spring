package com.demoone.test.services;

import com.demoone.test.model.dto.LoginDto;
import com.demoone.test.model.dto.RegisterDto;
import com.demoone.test.model.entity.User;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
