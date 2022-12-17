package com.github.ricxi.backend.task;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    // delete task
    // there needs to be validation in case the task does not exist
    // will this throw an error if the id is not found anyways?
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Transactional
    // I can't privide an empty field when creating a subject
    // but I can provide one that has an empty string
    public Task updateTask(Task taskData) {
        Task task = taskRepository
        .findById(taskData.getId())
        .orElseThrow(() -> new IllegalStateException("todo not found"));
    
        String subject = taskData.getSubject();
        String details = taskData.getDetails();
        Boolean complete = taskData.getComplete();

        if (Objects.nonNull(subject) 
            && !"".equalsIgnoreCase(subject)
            && !Objects.equals(task.getSubject(), subject)    
            ) {
                task.setSubject(subject);
        }

        if (Objects.nonNull(details) 
            && !"".equalsIgnoreCase(details)
            && !Objects.equals(task.getDetails(), details)    
            ) {
                task.setDetails(details);
        }
        
        // ! BUG: the field is set to false, when the "complete" field is missing in the JSON body
        if (Objects.nonNull(complete) 
            && !Objects.equals(task.getComplete(), complete)
            ) {
                task.setComplete(complete);
        }

        return task;   
    }
}
