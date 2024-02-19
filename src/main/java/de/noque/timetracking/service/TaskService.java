package de.noque.timetracking.service;

import de.noque.timetracking.model.Task;

public interface TaskService {
    Task get(Long id);

    Task create(Task task);

    Task update(Long id, Task task);

    void delete(Long id);
}
