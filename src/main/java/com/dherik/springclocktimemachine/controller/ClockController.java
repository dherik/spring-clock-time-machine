package com.dherik.springclocktimemachine.controller;

import com.dherik.springclocktimemachine.service.ClockService;
import com.dherik.springclocktimemachine.service.SomeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/clock")
public class ClockController {

    private final ClockService clockService;

    public ClockController(ClockService clockService) {
        this.clockService = clockService;
    }

    @GetMapping
    public ResponseEntity<ClockResponse> getCurrentTime() {
        ClockResponse clockResponse = clockService.getCurrentTime();
        return new ResponseEntity<>(clockResponse, HttpStatus.OK);
    }

    @GetMapping("/change")
    public ResponseEntity<ClockResponse> changeCurrentTime(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date
    ) {
        ClockResponse clockResponse = clockService.change(date);
        return new ResponseEntity<>(clockResponse, HttpStatus.OK);
    }

    @GetMapping("/release")
    public ResponseEntity<ClockResponse> release() {
        ClockResponse clockResponse = clockService.release();
        return new ResponseEntity<>(clockResponse, HttpStatus.OK);
    }

}
