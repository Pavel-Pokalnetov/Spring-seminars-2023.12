package ru.gb.pokalnetovps.hw11.service;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.gb.pokalnetovps.hw11.repository.IUserRepository;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MetricService {
    @Autowired
    IUserRepository repo;
    @Autowired
    MeterRegistry mr;
    public AtomicInteger userCounter;

    public MetricService() {
        userCounter = new AtomicInteger((int) repo.count());
        Gauge.builder("users_counter", userCounter, AtomicInteger::get)
                .description("Число пользователей в базе")
                .register(mr);
    }

    public void update() {
        userCounter.set((int) repo.count());
    }
}
