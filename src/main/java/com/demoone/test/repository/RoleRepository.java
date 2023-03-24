package com.demoone.test.repository;

import com.demoone.test.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    @Query(value = "SECT")
//    List<Role> findAll();
Role findByName(String name);
}
