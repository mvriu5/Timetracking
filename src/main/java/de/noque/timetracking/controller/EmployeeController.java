package de.noque.timetracking.controller;

import de.noque.timetracking.model.Employee;
import de.noque.timetracking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeService.get(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee employeeDb = employeeService.create(employee);
        return new ResponseEntity<>(employeeDb, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.update(id, employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>("Employee with the id '" + id + "' deleted successfully.", HttpStatus.OK);
    }
}
