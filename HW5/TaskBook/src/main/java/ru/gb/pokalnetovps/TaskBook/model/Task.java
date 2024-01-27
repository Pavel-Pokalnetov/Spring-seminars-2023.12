package ru.gb.pokalnetovps.TaskBook.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import static ru.gb.pokalnetovps.TaskBook.model.TaskStatus.*;

/**
 * Сущность "Задача"
 * @id - идентификатор
 * @name - наименование (заголовок)
 * @description - описание
 * @status - статус
 * @createdDate - дата создания
 */
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
        return status.toString();
    }
}
