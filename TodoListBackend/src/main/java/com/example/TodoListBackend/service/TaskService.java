package com.example.TodoListBackend.service;

import com.example.TodoListBackend.model.TaskModel;
import com.example.TodoListBackend.repository.TaskRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createNewTask(TaskModel taskModel) {
        taskRepository.save(taskModel);
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public void changeTaskStatus(Integer id) {
        TaskModel taskModel = taskRepository.findById(id).get();

        if (taskModel.getStatus().equals("No")) {
            taskModel.setStatus("In Progress");
        } else {
            taskModel.setStatus("Done");
        }
        taskRepository.save(taskModel);
    }
}
