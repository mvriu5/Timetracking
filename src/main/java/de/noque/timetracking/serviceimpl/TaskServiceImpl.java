package de.noque.timetracking.serviceimpl;

import de.noque.timetracking.exception.TaskNotFoundException;
import de.noque.timetracking.model.Task;
import de.noque.timetracking.repository.TaskRepository;
import de.noque.timetracking.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task get(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty()) throw new TaskNotFoundException(id);

        return task.get();
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllFromEmployee(Long employeeId) {
        return taskRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task) {
        Optional<Task> taskDb = taskRepository.findById(id);

        if (taskDb.isEmpty()) throw new TaskNotFoundException(id);

        taskDb.get().setTask(task.getTask());
        taskDb.get().setTimeCreated(task.getTimeCreated());
        taskDb.get().setTimeFrom(task.getTimeFrom());
        taskDb.get().setTimeTo(task.getTimeTo());

        return taskRepository.save(taskDb.get());
    }

    @Override
    public void delete(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty()) throw new TaskNotFoundException(id);

        taskRepository.deleteById(id);
    }

    @Override
    public void deleteAllFromEmployee(Long employeeId) {
       taskRepository.deleteByEmployeeId(employeeId);
    }
}
