package com.github.gtopinio.progresspal.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;

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

    @Async
    public CompletableFuture<Task> createTask(String title, String description, String category, String type, String userEmail) {

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Task task = new Task(title, description, category, type, userEmail, date, time);
        this.taskRepository.save(task);
        return CompletableFuture.completedFuture(task);
    }

    @Async
    public CompletableFuture<Task> updateTask(Long id, String title, String description, String category, String type, String userEmail) {
        Task task = this.taskRepository.findById(id).orElseThrow();
        task.setTitle(title);
        task.setDescription(description);
        task.setCategory(category);
        task.setType(type);
        task.setUserEmail(userEmail);
        this.taskRepository.save(task);
        return CompletableFuture.completedFuture(task);
    }

}
