package com.dherik.springclocktimemachine.service;

import com.dherik.springclocktimemachine.controller.ClockResponse;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ClockService {

    private final DeloreanComponent delorean;

    public ClockService(DeloreanComponent delorean) {
        this.delorean = delorean;
    }

    public ClockResponse change(LocalDateTime date) {

        Clock clockNew = Clock.fixed(date.atZone(ZoneId.systemDefault()).toInstant(),
                ZoneId.systemDefault());

        delorean.setClock(clockNew);

        return toResponse(this.delorean);
    }

    public ClockResponse getCurrentTime() {
        return toResponse(this.delorean);
    }

    private ClockResponse toResponse(DeloreanComponent delorean) {
        Clock clock = delorean.getClock();
        return new ClockResponse(clock.instant().atZone(clock.getZone()).toLocalDateTime());
    }

    public ClockResponse release() {
        this.delorean.setClock(Clock.systemDefaultZone());
        return toResponse(this.delorean);
    }
}
