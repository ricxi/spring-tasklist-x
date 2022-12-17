package com.github.ricxi.backend.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/task")
public class TaskController {
    
    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping(path = "/{taskId}")
    public Task getTask(@PathVariable(name  = "taskId") Long taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @DeleteMapping(path = "/{taskId}")
    public void deleteTask(@PathVariable(name = "taskId") Long taskId) {
        taskService.deleteTask(taskId);
    }
    
    @PutMapping
    public Task updateTask(@RequestBody Task taskData) {
        return taskService.updateTask(taskData);
    }
}
