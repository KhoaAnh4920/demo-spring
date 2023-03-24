package com.demoone.test.services.impl;

import com.demoone.test.model.Employee;
import com.demoone.test.repository.EmployeeRepository;
import com.demoone.test.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        if(employee != null)
            return employeeRepository.save(employee);
        return null;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        if(employee != null)
        {
            Employee employee1 = employeeRepository.findById(id).get();
            if(employee1 != null){
                employee1.setName(employee.getName());
                employee1.setAddress(employee.getAddress());
                return employeeRepository.save(employee1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(long id) {
        if(id < 1)
            return false;
        else{
            Employee employee = employeeRepository.findById(id).get();
            if(Objects.nonNull(employee))
                employeeRepository.delete(employee);
        }
        return true;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getDetail(long id) {
        return employeeRepository.findById(id).get();
    }
}
