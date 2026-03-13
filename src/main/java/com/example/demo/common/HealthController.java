package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class HealthController {

    @GetMapping("/health")
    public HealthResponse health() {
        log.info("[API-LOG]API호출이 완료되었습니다.");
        return new HealthResponse(
                "UP",
                LocalDateTime.now().toString()
        );
    }
}
