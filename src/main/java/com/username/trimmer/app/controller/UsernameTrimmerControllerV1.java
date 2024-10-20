package com.username.trimmer.app.controller;

import com.username.trimmer.app.model.service.UsernameTrimmerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v1/username/trim")
@RequiredArgsConstructor
public class UsernameTrimmerControllerV1 {

    private final UsernameTrimmerService service;

    @GetMapping
    public String trimmer(@ModelAttribute("username") String username) {
        return "trimmer";
    }

    @PostMapping
    public String trimmer(@ModelAttribute("username") String username, Model model) {
        String trimmedUsername = service.trim(username);
        model.addAttribute("username", trimmedUsername);

        return "trimmer";
    }
}
