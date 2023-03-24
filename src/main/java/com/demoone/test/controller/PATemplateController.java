package com.demoone.test.controller;

import com.demoone.test.model.Employee;
import com.demoone.test.model.dto.PATemplateDTO;
import com.demoone.test.model.entity.PATemplate;
import com.demoone.test.services.PATemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pa-template")
public class PATemplateController {

    @Autowired //
    private PATemplateService paTemplateService;

    @PostMapping("/add")
    public PATemplate addPATemplate(@RequestBody PATemplateDTO paTemplate){
        System.out.println("Check paTemplate: " + paTemplate.getName());
        return paTemplateService.addPATemplate(paTemplate);
    }

    @GetMapping("/")
    public List<PATemplate> getAll(){
        System.out.println("Run !!!!");
        return paTemplateService.getAllPATemplate();
    }
}
