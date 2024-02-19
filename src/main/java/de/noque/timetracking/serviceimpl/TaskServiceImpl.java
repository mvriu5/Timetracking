package de.noque.timetracking.serviceimpl;

import de.noque.timetracking.model.Task;
import de.noque.timetracking.repository.TaskRepository;
import de.noque.timetracking.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task get(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty())
            throw new RuntimeException("No task with the id '" + id + "' found.");

        return task.get();
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, Task task) {
        Optional<Task> taskDb = taskRepository.findById(id);

        if (taskDb.isEmpty())
            throw new RuntimeException("No task with the id '" + id + "' found.");

        taskDb.get().setTask(task.getTask());
        taskDb.get().setTimeCreated(task.getTimeCreated());
        taskDb.get().setTimeFrom(task.getTimeFrom());
        taskDb.get().setTimeTo(task.getTimeTo());

        return taskRepository.save(taskDb.get());
    }

    @Override
    public void delete(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty())
            throw new RuntimeException("No task with the id '" + id + "' found.");

        taskRepository.deleteById(id);
    }
}
