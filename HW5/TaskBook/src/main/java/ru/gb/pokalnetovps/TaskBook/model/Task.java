package ru.gb.pokalnetovps.TaskBook.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import static ru.gb.pokalnetovps.TaskBook.model.TaskStatus.*;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private TaskStatus status;
    @Column(name = "CREATEDDATE")
    private LocalDateTime createdDate;

    public String getStatusWeb() {
        return switch (status) {
            case NOT_STARTED -> "Не начат";
            case COMPLETED -> "Выполнено";
            case IN_PROGRESS -> "Выполняется";
        };
    }
}
