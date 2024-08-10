package dto;

import entity.Task;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String user;
    private LocalDateTime dueDate;

    Task task;

    public TaskDto convertToDto(Task savedTask) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus().name());
        taskDto.setDueDate(task.getDueDate());

        return taskDto;
    }
}
