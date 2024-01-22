package com.example.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@Setter
@Getter
@EqualsAndHashCode
@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
