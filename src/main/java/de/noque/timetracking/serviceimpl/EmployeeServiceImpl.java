package de.noque.timetracking.serviceimpl;

import de.noque.timetracking.exception.EmployeeNotFoundException;
import de.noque.timetracking.model.Employee;
import de.noque.timetracking.repository.EmployeeRepository;
import de.noque.timetracking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee get(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty()) throw new EmployeeNotFoundException(id);

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

        if (employeeDb.isEmpty()) throw new EmployeeNotFoundException(id);

        employeeDb.get().setName(employee.getName());
        employeeDb.get().setPassword(employee.getPassword());
        employeeDb.get().setRole(employee.getRole());

        return employeeRepository.save(employeeDb.get());
    }

    @Override
    public void delete(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty()) throw new EmployeeNotFoundException(id);

        employeeRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);

        if (employeeOptional.isEmpty()) throw new UsernameNotFoundException("User not exists by Username or Email");

        Employee employee = employeeOptional.get();
        Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(employee.getRole()));

        return new User(email, employee.getPassword(), authorities);
    }
}
