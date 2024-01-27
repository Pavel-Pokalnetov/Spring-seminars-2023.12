package ru.gb.pokalnetovps.TaskBook.model;

/**
 * Статусы задачи
 * @COMPLETED - Выполнена (завершена)
 * @IN_PROGRESS - Выполняется (в работе)
 * @NOT_STARTED - Не запущена
 */
public enum TaskStatus {
    COMPLETED{
        @Override
        public String toString() {
            return "Завершена";
        }
    },
    IN_PROGRESS{
        @Override
        public String toString() {
            return "Выполняется";
        }
    },
    NOT_STARTED{
        @Override
        public String toString() {
            return "Не выполняется";
        }
    }
}
