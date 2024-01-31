package ru.gb.pokalnetovps.hw7.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "user_group", nullable = false)
    private String userGroup;

}
