package com.username.trimmer.app.model.service;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UsernameTrimmerService {

    public String trim(String username) {
        return username.trim()
                .toLowerCase()
                .chars()
                .filter(Character::isLetter)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
