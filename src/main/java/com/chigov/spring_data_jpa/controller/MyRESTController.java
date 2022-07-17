package com.chigov.spring_data_jpa.controller;


import com.chigov.spring_data_jpa.entity.Employee;
import com.chigov.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

//    @ExceptionHandler
//    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception){
//
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception){
//
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public  Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.getEmployee(id);

       employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }

}
