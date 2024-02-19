package de.noque.timetracking.service;

import de.noque.timetracking.model.Employee;

public interface EmployeeService {

    Employee get(Long id);

    Employee create(Employee employee);

    Employee update(Long id, Employee employee);

    void delete(Long id);
}
