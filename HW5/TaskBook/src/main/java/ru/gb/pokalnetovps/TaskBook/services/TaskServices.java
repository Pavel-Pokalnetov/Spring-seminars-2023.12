package ru.gb.pokalnetovps.TaskBook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.TaskBook.model.Task;
import ru.gb.pokalnetovps.TaskBook.model.TaskStatus;
import ru.gb.pokalnetovps.TaskBook.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static ru.gb.pokalnetovps.TaskBook.model.TaskStatus.*;

/**
 * Сервис работы с задачами
 */
@Service
public class TaskServices {

    @Autowired
    TaskRepository taskRep;

    /** Получить ссписок всех задач
     * @return - список задач
     */
    public List<Task> getAllTask() {
        return StreamSupport.stream(taskRep.findAll().spliterator(), false).collect(Collectors.toList());
    }

    /** Записать задачу в базу
     * @param task - задача для записи
     */
    public void saveTask(Task task) {
        taskRep.save(task);
    }

    /** Создание новой задачи по имеющемуся Наименованияю и Описанию
     * создает задачу с текущим временем и статусом "Не запущена"
     * @param name - наименование задачи
     * @param description - описание задачи
     * @return - созданная задача
     */
    public Task addTask(String name, String description) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        task.setStatus(NOT_STARTED);
        task.setCreatedDate(LocalDateTime.now());
        return task;
    }

    /** Удаляет задачу по id
     * @param id - идентификатор удаляемой задачи
     */
    public void delTask(Long id) {
        if (taskRep.existsById(id))
            taskRep.deleteById(id);
    }

    /** Получить список задач по их статусу
     * @param taskStatus - статус задач для отбора
     * @return - список полученных задач
     */
    public List<Task> getTaskByStatus(TaskStatus taskStatus) {
        return taskRep.findByStatus(taskStatus);
    }

    /** Обновляет статус задачи с заданным id на следующий
     *  Не запущена >> Выполняется >> Выполнена
     *  в случае статуса Выполнена - ничего не изменяет
     * @param id
     */
    public void updateStatus(Long id) {
        if (taskRep.existsById(id)) {
            Task task = taskRep.findById(id).orElse(null);
            if (task != null) {
                switch (task.getStatus()) {
                    case NOT_STARTED -> {
                        //смена статуса "Не запущена" -> "Выполняется"
                        task.setStatus(IN_PROGRESS);
                    }
                    case IN_PROGRESS -> {
                        //смена статуса "Выполняется" -> "Выполнена"
                        task.setStatus(COMPLETED);
                    }
                    default -> {
                        //в остальных случаях не выполняет ничего
                        return;
                    }
                }
            }
            taskRep.save(task);
        }
    }
}
