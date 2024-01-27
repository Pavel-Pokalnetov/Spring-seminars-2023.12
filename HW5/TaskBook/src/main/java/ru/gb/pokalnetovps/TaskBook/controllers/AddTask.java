package ru.gb.pokalnetovps.TaskBook.controllers;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.pokalnetovps.TaskBook.services.TaskServices;

/**
 * Обработка запросов добавления задачи
 * GET - "/addtask" - вывод HTML формы
 * POST - "/addtask - обработка формы
 */
@Controller
@Log
public class AddTask {
    @Autowired
    TaskServices ts;

    /**
     * Вывод формы для ввода заголовка и описания задачи
     *
     * @return - вывод страницы с формой ввода задачи
     */
    @GetMapping("/addtask")
    public String addTaskForm() {
        return "addtask";
    }

    /**
     * Обработчик POST запроса на создание задачи
     *
     * @param name        - имя задачи
     * @param description - описание задачи
     * @return - перехад на стартовую странице
     */
    @PostMapping("/addtask")
    public String addTaskAction(
            @RequestParam String name,
            @RequestParam String description,
            Model model) {
        ts.saveTask(ts.addTask(name, description));
        model.addAttribute("tasks", ts.getAllTask());
        return "index";
    }
}
