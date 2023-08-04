package com.valmiki.vidyarthimgmt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vidyarthi")
public class VidyarthiController {
    @GetMapping("/greet")
    ResponseEntity<String> hello() {
        return ResponseEntity.ok("Suprabhat Bhavi Vidyarthi!");
    }
}
