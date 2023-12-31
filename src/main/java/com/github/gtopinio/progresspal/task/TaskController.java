package com.github.gtopinio.progresspal.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Controller
@CrossOrigin
public class TaskController {
    // Responsible for handling requests and returning responses

    private final TaskService taskService;


    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @QueryMapping
    Iterable<Task> tasks() {
        return this.taskService.getTasks();
    }

    @QueryMapping
    Iterable<Task> taskByEmail(@Argument String userEmail) {
        return this.taskService.getTasksByEmail(userEmail);
    }

    @MutationMapping
    CompletableFuture<Task> createTask(@Argument TaskInput task) {
        return this.taskService.createTask(task.title, task.description, task.category, task.type, task.userEmail);
    }

    @MutationMapping
    CompletableFuture<Task> updateTask(@Argument Long id, @Argument TaskInput task) {
        return this.taskService.updateTask(id, task.title, task.description, task.category, task.type, task.userEmail);
    }

    @MutationMapping
    CompletableFuture<Optional<DeleteTaskResponse>> deleteTask(@Argument Long id) {
        return this.taskService.deleteTask(id);
    }

    record TaskInput(String title, String description, String category, String type, String userEmail) {
    }

    record DeleteTaskResponse(Boolean success, String message) {
    }

}
