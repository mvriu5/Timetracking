package de.noque.timetracking.service;

import de.noque.timetracking.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee get(Long id);

    List<Employee> getAll();

    Employee create(Employee employee);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}
