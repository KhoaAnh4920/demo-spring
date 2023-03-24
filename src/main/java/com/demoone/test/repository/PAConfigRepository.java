package com.demoone.test.repository;

import com.demoone.test.model.entity.PAConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PAConfigRepository extends JpaRepository<PAConfig, Long> {
}
