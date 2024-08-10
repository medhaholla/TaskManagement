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

    public Task createTask(Task task){
        return taskRepository.save(task);
    }





}


