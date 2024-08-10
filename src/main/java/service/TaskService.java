package service;

import dto.TaskDto;
import entity.Task;
import entity.TaskStatus;
import entity.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import repository.TaskRepository;
import repository.UserRepository;

public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task getTask(long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Task not found with id " + id));
    }

    public Task updateTask(Task task) {
        long taskId = task.getId();

        Task existingTask = taskRepository.findById(task.getId()).orElseThrow(() -> new EntityNotFoundException("Task with id " + taskId + "not found"));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());

        Task updatedTask = taskRepository.save(existingTask);
        return updatedTask;

    }




    public boolean doesTaskExist(Long id) {
        return taskRepository.existsById(id);
    }



}


