package com.demoone.test.services.impl;

import com.demoone.test.model.dto.PATemplateDTO;
import com.demoone.test.model.entity.PATemplate;
import com.demoone.test.repository.PATemplateRepository;
import com.demoone.test.services.PATemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PATemplateServiceImpl implements PATemplateService {

    @Autowired
    private PATemplateRepository paTemplateRepository;
    @Override
    public PATemplate addPATemplate(PATemplateDTO paTemplate) {
        System.out.println("Check paTemplate: " + paTemplate);
        if(Objects.nonNull(paTemplate)){
            PATemplate paTemplate1 = new PATemplate();
            paTemplate1.setName(paTemplate.getName());
            paTemplate1.setDescription(paTemplate.getDescription());
            return paTemplateRepository.save(paTemplate1);
        }
        return null;
    }

    @Override
    public PATemplate updatePATemplate(long id, PATemplate paTemplate) {
        return null;
    }

    @Override
    public boolean deletePATemplate(long id) {
        return false;
    }

    @Override
    public List<PATemplate> getAllPATemplate() {
        return paTemplateRepository.findAll();
    }

    @Override
    public PATemplate getDetail(long id) {
        return null;
    }

    @Override
    public List<PATemplate> findAllByIdIn(List<Long> userIds) {
        System.out.println("userIds: " + userIds);
        return paTemplateRepository.findAllById(userIds);
    }
}
