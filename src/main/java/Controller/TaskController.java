package Controller;

import entity.Task;
import org.springframework.data.domain.Page;
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
    @GetMapping("/api/tasks")
    public ResponseEntity<Page<Task>> getTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Task> tasks = taskService.getTasks(page, size);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("api/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task task){

        task.setId(id);
        Task updatedTask = taskService.updateTask(task);
        return new ResponseEntity<>(updatedTask , HttpStatus.OK);
    }

    @DeleteMapping("api/deleteTask/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id){
        taskService.deleteTask(id);

        return new ResponseEntity<>("Task is successfully deleted !!" , HttpStatus.OK);
    }

}