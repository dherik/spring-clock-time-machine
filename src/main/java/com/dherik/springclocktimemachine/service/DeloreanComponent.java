package com.dherik.springclocktimemachine.service;

import org.springframework.stereotype.Component;

import java.time.Clock;

@Component
public class DeloreanComponent {

    private Clock clock;

    public DeloreanComponent(Clock clock) {
        this.clock = clock;
    }

    void setClock(Clock clock) {
        this.clock = clock;
    }

    Clock getClock() {
        return clock;
    }
}
