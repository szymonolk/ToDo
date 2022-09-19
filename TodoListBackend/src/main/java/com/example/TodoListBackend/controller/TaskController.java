package com.example.TodoListBackend.controller;

import com.example.TodoListBackend.model.TaskModel;
import com.example.TodoListBackend.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/create")
    public void createTask(@RequestBody TaskModel taskModel) {
        taskService.createNewTask(taskModel);
    }


    @GetMapping("/all")
    public List<TaskModel> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable("id") Integer id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/update/{id}")
    public void UpdateStatus(@PathVariable Integer id){
        taskService.changeTaskStatus(id);
    }

}
