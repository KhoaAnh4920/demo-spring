package com.demoone.test.services;

import com.demoone.test.model.dto.RoleDTO;
import com.demoone.test.model.entity.PATemplate;
import com.demoone.test.model.entity.Role;

import java.util.List;

public interface IRoleService {

    public Role addRole(RoleDTO role);

    public List<Role> getAllRole();

    public List<Role> findAllByIdIn(List<Long> roleIds);
}
