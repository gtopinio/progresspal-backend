package com.github.gtopinio.progresspal.task;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private String title;
    private String description;
    private String category;
    private String type;
    private String userEmail;
    private LocalDate date;
    private LocalTime time;

    public Task(String title, String description, String category, String type, String userEmail, LocalDate date, LocalTime time) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.type = type;
        this.userEmail = userEmail;
        this.date = date;
        this.time = time;
    }

    public String email() {
        return this.userEmail;
    }

}
