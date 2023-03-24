package com.demoone.test.repository;

import com.demoone.test.model.entity.PA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PARepository extends JpaRepository<PA, Long> {
}
