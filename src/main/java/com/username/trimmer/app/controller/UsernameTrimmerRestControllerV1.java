package com.username.trimmer.app.controller;

import com.username.trimmer.app.model.service.UsernameTrimmerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user/trim")
@RequiredArgsConstructor
public class UsernameTrimmerRestControllerV1 {

    private final UsernameTrimmerService service;

    @PostMapping
    public ResponseEntity<Map<String, String>> trimmer(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String trimmedUsername = service.trim(username);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("trimmed_username", trimmedUsername);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
