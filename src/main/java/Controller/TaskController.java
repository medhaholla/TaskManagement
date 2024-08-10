package Controller;

import entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.TaskRepository;
import service.TaskService;

@RestController
public class TaskController {
    private TaskService taskService;

    @PostMapping("/api/saveTask")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task savedTask = taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("api/getTask/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id){
        Task task = taskService.getTask(id);
        return new ResponseEntity<>(task , HttpStatus.OK);
    }

}