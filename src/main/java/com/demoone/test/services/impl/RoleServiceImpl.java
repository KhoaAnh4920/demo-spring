package com.demoone.test.services.impl;

import com.demoone.test.model.dto.RoleDTO;
import com.demoone.test.model.entity.Role;
import com.demoone.test.repository.RoleRepository;
import com.demoone.test.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(RoleDTO role) {
        System.out.println("role: " + role);
        Role createRole = new Role();
        createRole.setName(role.getName());
        createRole.setDescription(role.getDescription());
        return roleRepository.save(createRole);
    }

    @Override
    public List<Role> getAllRole(){
        System.out.println("Run !!!!");
        List<Role> test = roleRepository.findAll();
        System.out.println("Check: " + test);
        return test;
    }

    @Override
    public List<Role> findAllByIdIn(List<Long> roleIds) {
        System.out.println("roleIds: " + roleIds);
        return roleRepository.findAllById(roleIds);
    }
}
