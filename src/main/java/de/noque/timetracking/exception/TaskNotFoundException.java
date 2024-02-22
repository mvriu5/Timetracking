package de.noque.timetracking.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException() {}

    public TaskNotFoundException(Long id) {
        super(String.format("Task with the id: %s not found.", id));
    }

}
