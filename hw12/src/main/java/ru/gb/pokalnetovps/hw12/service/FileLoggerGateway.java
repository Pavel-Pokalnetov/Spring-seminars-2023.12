package ru.gb.pokalnetovps.hw12.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import ru.gb.pokalnetovps.hw12.model.User;

@MessagingGateway(defaultRequestChannel = "inChannel")
public interface FileLoggerGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, User user);
}
