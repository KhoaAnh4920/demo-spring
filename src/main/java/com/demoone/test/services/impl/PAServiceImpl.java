package com.demoone.test.services.impl;

import com.demoone.test.model.dto.PADto;
import com.demoone.test.model.entity.PA;
import com.demoone.test.model.entity.PAConfigTemplate;
import com.demoone.test.model.entity.User;
import com.demoone.test.repository.PAConfigTemplateRepository;
import com.demoone.test.repository.PARepository;
import com.demoone.test.repository.UserRepository;
import com.demoone.test.services.PAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PAServiceImpl implements PAService {

    @Autowired
    private PARepository paRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PAConfigTemplateRepository paConfigTemplateRepository;
    @Override
    public PA addPa(PADto pa) {
        System.out.println("aaaaa");
        if(Objects.nonNull(pa)){
            PA pa1 = new PA();
            pa1.setName(pa.getName());
            pa1.setDescription(pa.getDescription());
            pa1.setStartDate(pa.getStartDate());
            pa1.setEndDate(pa.getEndDate());
            User user1 = userRepository.findById(pa.getUserId()).orElse(null);
//            PAConfigTemplate paConfigTemplateRepository = paConfigTemplateRepository.getReferenceById(pa.getPaConfigTemplateId());
            System.out.println(user1);
            pa1.setUser(user1);
            //pa1.setPaConfigTemplate(paConfigTemplate);
            PA insertPa = paRepository.save(pa1);
            return insertPa;
        }
        return null;
    }

    @Override
    public PA updatePa(long id, PA pa) {
        return null;
    }

    @Override
    public boolean deletePa(long id) {
        return false;
    }

    @Override
    public List<PA> getAllPa() {
        return paRepository.findAll();
    }

    @Override
    public PA getDetail(long id) {
        return null;
    }
}
