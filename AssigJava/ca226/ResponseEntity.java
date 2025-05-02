package com.just.ca226;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
public class ResponseEntity {
    @GetMapping("/success")
    public org.springframework.http.ResponseEntity<String> success() {
        return org.springframework.http.ResponseEntity
                .ok()
                .header("X-Custom-Header", "MyValue")
                .body("Operation succeeded with a custom header!");
    }


    @GetMapping("/not-found")
    public org.springframework.http.ResponseEntity<Map<String, String>> notFound() {
        Map<String, String> error = Map.of("error", "Resource not found");
        return org.springframework.http.ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }


    @PostMapping("/create")
    public org.springframework.http.ResponseEntity<String> createResource() {
        URI location = URI.create("/resource/123");
        return org.springframework.http.ResponseEntity
                .created(location)
                .body("Resource created with ID 123");
    }
}
