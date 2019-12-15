package com.dherik.springclocktimemachine.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SomeService {

    private final DeloreanComponent delorean;

    SomeService(DeloreanComponent delorean) {
        this.delorean = delorean;
    }

    boolean isEventDateBeforeToday(LocalDate event) {
        return event.isBefore(LocalDate.now(delorean.getClock()));
    }
}
