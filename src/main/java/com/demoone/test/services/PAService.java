package com.demoone.test.services;

import com.demoone.test.model.Employee;
import com.demoone.test.model.dto.PADto;
import com.demoone.test.model.entity.PA;

import java.util.List;

public interface PAService {

    public PA addPa(PADto paDto);
    public PA updatePa(long id , PA pa);

    public boolean deletePa(long id);

    public List<PA> getAllPa();

    public PA getDetail(long id);
}
