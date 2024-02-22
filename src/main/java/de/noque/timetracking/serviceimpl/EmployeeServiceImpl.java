package de.noque.timetracking.serviceimpl;

import de.noque.timetracking.exception.EmployeeNotFoundException;
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

    /*@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findEmployeeByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        Set<GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(employee.getRole()));

        return new User(email, employee.getPassword(), authorities);
    }*/
}
