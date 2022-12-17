package com.github.ricxi.backend.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    // I need to write a custom exception
    // to account for cases where the task was not found
    public Task getTask(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow();
    }

    // I don't think I need to make a custom exception
    // if I can't add a task because that would definitely be
    // a server error that I did not plan
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
}
