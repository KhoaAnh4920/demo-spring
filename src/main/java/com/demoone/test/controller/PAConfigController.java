package com.demoone.test.controller;


import com.demoone.test.model.dto.PAConfigDTO;
import com.demoone.test.model.entity.PAConfig;
import com.demoone.test.model.entity.PATemplate;
import com.demoone.test.services.PAConfigService;
import com.demoone.test.services.PATemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pa-config")
public class PAConfigController {

    @Autowired //
    private PAConfigService paConfigService;

    @Autowired //
    private PATemplateService paTemplateService;

    @PostMapping("/add")
    public PAConfig addPAConfig(@RequestBody PAConfigDTO paConfigDTO){
        System.out.println("Check paConfigDTO: " + paConfigDTO);
        System.out.println("Test ids: " + paTemplateService.findAllByIdIn(paConfigDTO.getIds()));
        List<PATemplate> paTemplateList =  paTemplateService.findAllByIdIn(paConfigDTO.getIds());
        return paConfigService.addPAConfig(paConfigDTO, paTemplateList);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PAConfig>> getAll(){
        System.out.println("Run !!!!");
        return ResponseEntity.ok(paConfigService.getAllPAConfig());
    }

}
