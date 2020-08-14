package com.adidyk;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class EmployeeController.
 */
@RestController
public class EmployeeController {

    @RequestMapping (value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee() {
        Employee employee = new Employee();
        employee.setEmpId("1");
        employee.setName("Bob");
        employee.setDesignation("manager");
        employee.setSalary(1000);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
