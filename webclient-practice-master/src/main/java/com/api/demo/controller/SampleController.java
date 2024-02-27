package com.api.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SampleController {
    @GetMapping("/")
    public ResponseEntity<?> sample(HttpServletRequest request){
        log.info("진입 성공 {} {}", request.getRequestURL(), request.getRequestURI());

        return ResponseEntity.ok("Hello World!");
    }
}
