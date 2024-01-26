package ru.gb.pokalnetovps.TaskBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.pokalnetovps.TaskBook.services.TaskServices;

@SpringBootApplication
public class TaskBookApp {

	public static void main(String[] args) {
		SpringApplication.run(TaskBookApp.class, args);
	}

}
