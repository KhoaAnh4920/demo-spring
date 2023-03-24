package com.demoone.test.controller;

import com.demoone.test.model.dto.PAConfigDTO;
import com.demoone.test.model.dto.PADto;
import com.demoone.test.model.entity.PA;
import com.demoone.test.model.entity.PAConfig;
import com.demoone.test.model.entity.PATemplate;
import com.demoone.test.services.PAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pa")
public class PAController {

    @Autowired //
    private PAService paService;

    @PostMapping("/add")
    public PA addPA(@RequestBody PADto paDto){
        System.out.println("Check paDto: " + paDto);
        return paService.addPa(paDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<PA>> getAll(){
        System.out.println("Run !!!!");
        return ResponseEntity.ok(paService.getAllPa());
    }
}
