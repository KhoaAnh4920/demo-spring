package com.demoone.test.services;

import com.demoone.test.model.Employee;
import com.demoone.test.model.dto.PATemplateDTO;
import com.demoone.test.model.entity.PATemplate;

import java.util.List;

public interface PATemplateService {

    public PATemplate addPATemplate(PATemplateDTO paTemplate);
    public PATemplate updatePATemplate(long id , PATemplate paTemplate);

    public boolean deletePATemplate(long id);

    public List<PATemplate> getAllPATemplate();

    public PATemplate getDetail(long id);
    public List<PATemplate> findAllByIdIn(List<Long> userIds);
}
