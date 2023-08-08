package com.github.gtopinio.progresspal.task;

//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class TaskConfig {
//    // Responsible for mockup data
//
//    @Bean
//    CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
//        return args -> {
//            Task task1 = new Task(
//                    "Task 1",
//                    "Description 1",
//                    "toDo",
//                    "do",
//                    "markgenesistopinio@gmail.com",
//                    LocalDate.of(2023, Month.JANUARY, 1)
//            );
//
//            Task task2 = new Task(
//                    "Task 2",
//                    "Description 2",
//                    "toDo",
//                    "delegate",
//                    "markgenesistopinio@gmail.com",
//                    LocalDate.of(2023, Month.FEBRUARY, 2)
//            );
//
//            taskRepository.saveAll(
//                    List.of(task1, task2));
//        };
//    }

}
