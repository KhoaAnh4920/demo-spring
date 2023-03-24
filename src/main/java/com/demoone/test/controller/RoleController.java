package com.demoone.test.controller;

import com.demoone.test.model.dto.RoleDTO;
import com.demoone.test.model.entity.Role;
import com.demoone.test.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    @PostMapping("/add")
    private Role addNewRole(@RequestBody RoleDTO req){
        System.out.println("req: " + req);
        return iRoleService.addRole(req);
    }

    @GetMapping("/")
    private List<Role> getAllRoles(){
        System.out.println("AAA");
        return iRoleService.getAllRole();
    }

}
