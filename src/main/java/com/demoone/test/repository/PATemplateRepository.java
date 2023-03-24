package com.demoone.test.repository;

import com.demoone.test.model.entity.PATemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PATemplateRepository extends JpaRepository<PATemplate, Long> {
}
