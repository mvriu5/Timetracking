package de.noque.timetracking.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {}

    public EmployeeNotFoundException(Long id) {
        super(String.format("Employee with the id: %s not found.", id));
    }

    public EmployeeNotFoundException(String email) {
        super(String.format("Employee with the email: %s not found.", email));
    }
}
