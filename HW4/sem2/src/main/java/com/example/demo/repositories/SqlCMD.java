package com.example.demo.repositories;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигуратор SQL запросов
 */
@Configuration
@ConfigurationProperties(prefix = "sqlcmd")
@Setter
@Getter
public class SqlCMD {
    private String findAll;
    private String save;
    private String delete;
    private String getById;
    private String update;
    private String count;
}
