package com.github.gtopinio.progresspal.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
    // Responsible for database access

    List<Task> findByUserEmail(String userEmail);

}
