package com.dherik.springclocktimemachine.service;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeServiceTest {

    @Test
    void process() {

        LocalDateTime primeiroJaneiro2018 = LocalDate.of(2018, 1, 1).atStartOfDay();
        Clock clock = Clock.fixed(primeiroJaneiro2018.atZone(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault());

        DeloreanComponent deloreanComponent = mock(DeloreanComponent.class);
        when(deloreanComponent.getClock())
                .thenReturn(clock);

        SomeService someService = new SomeService(deloreanComponent);

        LocalDate eventDate = LocalDate.of(2017, 5, 5);
        boolean process = someService.process(eventDate);
        assertTrue(process);
    }
}