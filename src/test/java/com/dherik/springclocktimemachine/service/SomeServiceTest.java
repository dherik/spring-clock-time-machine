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
    void processEventDate() {

        LocalDateTime firstJanuary2018 = LocalDate.of(2018, 1, 1).atStartOfDay();
        Clock clockChanged = Clock.fixed(firstJanuary2018.atZone(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault());

        DeloreanComponent deloreanComponent = mockDeloreanComponent(clockChanged);

        SomeService someService = new SomeService(deloreanComponent);

        LocalDate eventDate = LocalDate.of(2017, 5, 5);
        boolean isBefore = someService.isEventDateBeforeToday(eventDate);
        assertTrue(isBefore);
    }

    private DeloreanComponent mockDeloreanComponent(Clock clock) {
        DeloreanComponent deloreanComponent = mock(DeloreanComponent.class);
        when(deloreanComponent.getClock()).thenReturn(clock);
        return deloreanComponent;
    }
}