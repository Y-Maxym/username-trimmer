package com.username.trimmer.app.service;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class UsernameTrimmerService {

    public String trim(String username) {
        if (isBlank(username)) {
            return username;
        }

        return username.trim()
                .toLowerCase()
                .chars()
                .filter(Character::isLetter)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
