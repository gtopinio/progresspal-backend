package com.github.gtopinio.progresspal.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
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

}
