package com.dherik.springclocktimemachine.controller;

import java.time.LocalDateTime;

public class ClockResponse {

    private LocalDateTime date;

    public ClockResponse(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
