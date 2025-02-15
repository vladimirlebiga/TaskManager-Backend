package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskStatus;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }


//    public List<Task> getAllTasks(String status) {
//        if (status != null && !status.isEmpty()) {
//            return taskRepository.findByStatus(status);
//        }
//        return taskRepository.findAll();
//    }

    public List<Task> getAllTasks(String status) {
        if (status != null && !status.isEmpty()) {
            try {
                TaskStatus taskStatus = TaskStatus.valueOf(status.toUpperCase()); // Convert String to Enum
                return taskRepository.findByStatus(taskStatus);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid status: " + status); // Handle invalid enums
            }
        }
        return taskRepository.findAll();
    }

    public Task updateTask(Long id, Task taskDetails) {
        // 🔹 Fetch existing task from the database
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        // 🔹 Retain old values if new ones are null
        if (taskDetails.getTitle() != null) {
            task.setTitle(taskDetails.getTitle());
        }

        if (taskDetails.getDescription() != null) {
            task.setDescription(taskDetails.getDescription());
        }

        if (taskDetails.getStatus() != null) {
            task.setStatus(taskDetails.getStatus());
        }

        return taskRepository.save(task);
    }

    public Long deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.deleteById(id);
        return id;
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

}