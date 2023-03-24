package com.demoone.test.controller;

import com.demoone.test.model.Employee;
import com.demoone.test.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired //
    private IEmployeeService iEmployeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        System.out.println("Check employee: " + employee.getName());
        return iEmployeeService.addEmployee((employee));
    }

    @GetMapping("/")
    public List<Employee> getAll(){
        System.out.println("Run !!!!");
        return iEmployeeService.getAllEmployee();
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestParam("id") long id, @RequestBody Employee employee){
        System.out.println("id: " + id);
        return iEmployeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable("id") long id){
        return iEmployeeService.deleteEmployee(id);
    }

    @GetMapping("/detail/{id}")
    public Employee getDetailEmployee(@PathVariable("id") long id){
        System.out.println("id: " + id);
        return iEmployeeService.getDetail(id);
    }
}
