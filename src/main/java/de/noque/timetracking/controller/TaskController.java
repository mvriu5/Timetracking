package de.noque.timetracking.controller;

import de.noque.timetracking.model.Employee;
import de.noque.timetracking.model.Task;
import de.noque.timetracking.service.EmployeeService;
import de.noque.timetracking.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/tasks")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") Long id) {
        Task task = taskService.get(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Task>> getAllTasksFromEmployee(@PathVariable("employeeId") Long employeeId) {
        List<Task> tasks = taskService.getAllFromEmployee(employeeId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task taskDb = taskService.create(task);
        return new ResponseEntity<>(taskDb, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        Task updatedTask = taskService.update(id, task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
        taskService.delete(id);
        return new ResponseEntity<>("Task with the id '" + id + "' deleted successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<?> deleteAllTasksFromEmployee(@PathVariable("employeeId") Long employeeId) {
        taskService.deleteAllFromEmployee(employeeId);
        return new ResponseEntity<>("Tasks from employee '" + employeeId + "' deleted successfully.", HttpStatus.OK);
    }
}
