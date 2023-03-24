package com.demoone.test.services;

import com.demoone.test.model.dto.PAConfigDTO;
import com.demoone.test.model.entity.PAConfig;
import com.demoone.test.model.entity.PATemplate;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PAConfigService {

    public PAConfig addPAConfig(PAConfigDTO paConfigDTO, List<PATemplate> paTemplateList);
    public PAConfig updatePAConfig(long id , PAConfig paConfig);

    public boolean deletePAConfig(long id);

    @Query("SELECT s FROM pa_config s JOIN FETCH s.paConfigTemplate e JOIN FETCH e.paTemplate")
    public List<PAConfig> getAllPAConfig();


    public PAConfig getDetail(long id);
}
