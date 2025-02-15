package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//public interface TaskRepository extends JpaRepository<Task, Long> {
//    List<Task> findByStatus(String status);
//}

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status); // ✅ Ensure this uses TaskStatus
}

