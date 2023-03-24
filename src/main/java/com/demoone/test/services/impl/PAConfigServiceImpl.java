package com.demoone.test.services.impl;

import com.demoone.test.model.dto.PAConfigDTO;
import com.demoone.test.model.entity.PAConfig;
import com.demoone.test.model.entity.PAConfigTemplate;
import com.demoone.test.model.entity.PATemplate;
import com.demoone.test.repository.PAConfigRepository;
import com.demoone.test.repository.PAConfigTemplateRepository;
import com.demoone.test.repository.PATemplateRepository;
import com.demoone.test.services.PAConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PAConfigServiceImpl implements PAConfigService {

    @Autowired
    private PAConfigRepository paConfigRepository;

    @Autowired
    private PAConfigTemplateRepository paConfigTemplateRepository;

    @Override
    public PAConfig addPAConfig(PAConfigDTO paConfigDTO, List<PATemplate> paTemplateList) {
        System.out.println("Check paConfigDTO ids: " + paConfigDTO.getIds());
        if(Objects.nonNull(paConfigDTO)){
            PAConfig paConfig = new PAConfig();
            paConfig.setName(paConfigDTO.getName());
            paConfig.setDescription(paConfigDTO.getDescription());
            paConfig.setStartDate(paConfigDTO.getStartDate());
            paConfig.setEndDate(paConfigDTO.getEndDate());
            PAConfig res = paConfigRepository.save(paConfig);
            List<PAConfigTemplate> paConfigTemplateList = new ArrayList<>();
            for (PATemplate paTemplate : paTemplateList) {
                PAConfigTemplate paConfigTemplate = new PAConfigTemplate();
                paConfigTemplate.setPaConfig(paConfig);
                paConfigTemplate.setPaTemplate(paTemplate);
                paConfigTemplateList.add(paConfigTemplate);
//                paConfigTemplateRepository.save(paConfigTemplate);
            }
            paConfigTemplateRepository.saveAll(paConfigTemplateList);
//            paConfig.set(paTemplateList);
            return res;
        }
        return null;
    }

    @Override
    public PAConfig updatePAConfig(long id, PAConfig paConfig) {
        return null;
    }

    @Override
    public boolean deletePAConfig(long id) {
        return false;
    }

    @Override
    public List<PAConfig> getAllPAConfig() {
        List<PAConfig> result = paConfigRepository.findAll();
        return paConfigRepository.findAll();
    }

    @Override
    public PAConfig getDetail(long id) {
        return null;
    }
}
