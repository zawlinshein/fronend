package com.example.ajax.fronend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ajax.fronend.entity.Task;
import com.example.ajax.fronend.repo.TaskRepo;

@Service
public class TaskService {

    public final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    } 

    public Task findById(int id) {
        return taskRepo.findById(id).orElse(null);
    }
    
    public void save(Task task) {
        taskRepo.save(task);
    }

    public List<Task> getAll() {
        return taskRepo.findAll();
    }

}
