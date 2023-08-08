package com.github.gtopinio.progresspal.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    // Responsible for business logic

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> getTasks() {
        return this.taskRepository.findAll();
    }

    public Iterable<Task> getTasksByEmail(String userEmail) {
        return this.taskRepository.findByUserEmail(userEmail);

    }

}
