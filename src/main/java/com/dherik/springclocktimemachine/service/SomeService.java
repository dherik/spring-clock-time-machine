package com.dherik.springclocktimemachine.service;

import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;

@Service
public class SomeService {

    private final Clock clock;

    public SomeService(Clock clock) {
        this.clock = clock;
    }

    public boolean process(LocalDate event) {
        return event.isBefore(LocalDate.now(clock));
    }
}
