package ru.gb.pokalnetovps.hw9ms1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    private long id;
    @Column
    private String title;
    @Column
    private String text;
    @Column(name = "user_id")
    private long userId;

}
