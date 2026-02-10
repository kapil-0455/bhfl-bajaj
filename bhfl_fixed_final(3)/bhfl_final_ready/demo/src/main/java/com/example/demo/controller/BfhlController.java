package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.service.LogicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BfhlController {

    private final LogicService service;
    private final String EMAIL = "kapil0455.be23@chitkara.edu.in";

    public BfhlController(LogicService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public ResponseEntity<ApiResponse> health() {
        return ResponseEntity.ok(new ApiResponse(true, EMAIL, null));
    }

    @PostMapping("/bfhl")
    public ResponseEntity<?> bfhl(@RequestBody Map<String, Object> body) {
        try {

            if (body.containsKey("fibonacci")) {
                int n = (int) body.get("fibonacci");
                return ResponseEntity.ok(new ApiResponse(true, EMAIL, service.fibonacci(n)));
            }

            if (body.containsKey("prime")) {
                List<Integer> arr = (List<Integer>) body.get("prime");
                return ResponseEntity.ok(new ApiResponse(true, EMAIL, service.primes(arr)));
            }

            if (body.containsKey("hcf")) {
                List<Integer> arr = (List<Integer>) body.get("hcf");
                return ResponseEntity.ok(new ApiResponse(true, EMAIL, service.hcf(arr)));
            }

            if (body.containsKey("lcm")) {
                List<Integer> arr = (List<Integer>) body.get("lcm");
                return ResponseEntity.ok(new ApiResponse(true, EMAIL, service.lcm(arr)));
            }

            if (body.containsKey("AI")) {
                String q = (String) body.get("AI");
                return ResponseEntity.ok(new ApiResponse(true, EMAIL, service.aiAnswer(q)));
            }

            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, EMAIL, "Invalid request key"));

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new ApiResponse(false, EMAIL, "Server error"));
        }
    }
}