package ru.gb.pokalnetovps.hw11.service;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Сервис дополнительных метрик
 */
@Component
public class MetricService {
    /**
     * Счетчик пользователей в базе
     */
    private final AtomicInteger usersCounter;

    @Autowired
    public MetricService(MeterRegistry meterRegistry) {
        usersCounter = new AtomicInteger(0);

        Gauge.builder("users_in_database", usersCounter, AtomicInteger::get)
                .description("Число пользователей в базе")
                .register(meterRegistry);
    }

    /** Обновление метрики счетчика пользователей
     * @param newValue - новое значение метрики
     */
    public void updateUsersCounter(int newValue) {
        usersCounter.set(newValue);
    }
}
