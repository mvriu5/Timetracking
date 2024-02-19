package de.noque.timetracking.service;

import de.noque.timetracking.model.Task;

import java.util.List;

public interface TaskService {
    Task get(Long id);

    List<Task> getAll();

    List<Task> getAllFromEmployee(Long employeeId);

    Task create(Task task);

    Task update(Long id, Task task);

    void delete(Long id);

}
