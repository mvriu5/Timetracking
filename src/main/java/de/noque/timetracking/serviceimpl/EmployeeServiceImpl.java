package de.noque.timetracking.serviceimpl;

import de.noque.timetracking.model.Employee;
import de.noque.timetracking.repository.EmployeeRepository;
import de.noque.timetracking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee get(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty())
            throw new RuntimeException("No employee with the id '" + id + "' found.");

        return employee.get();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Optional<Employee> employeeDb = employeeRepository.findById(id);

        if (employeeDb.isEmpty())
            throw new RuntimeException("No employee with the id '" + id + "' found.");

        employeeDb.get().setName(employee.getName());
        employeeDb.get().setPassword(employee.getPassword());
        employeeDb.get().setRole(employee.getRole());

        return employeeRepository.save(employeeDb.get());
    }

    @Override
    public void delete(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty())
            throw new RuntimeException("No employee with the id '" + id + "' found.");

        employeeRepository.deleteById(id);
    }
}
