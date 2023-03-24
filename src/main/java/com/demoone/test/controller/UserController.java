package com.demoone.test.controller;

import com.demoone.test.model.entity.User;
import com.demoone.test.services.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired //
    private IUserService iUserService;

    @GetMapping("/")
    public List<User> getAll(){
        System.out.println("Run !!!!");
       return iUserService.getAllUser();
    }
}
