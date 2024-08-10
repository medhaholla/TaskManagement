package entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
//import jdk.internal.icu.text.UTF16;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity

@Getter
@Setter
public class Task {
//    public static UTF16 status;
    @Id
    Long id;

    private String title;
    private String description;
     @Enumerated(EnumType.STRING)
     @Column(nullable = false)
    private TaskStatus status;

    @ManyToOne
    private User user;

    private LocalDateTime dueDate;
}


