package com.username.trimmer.app.model.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsernameTrimmerServiceTest {


    private final UsernameTrimmerService service = new UsernameTrimmerService();

    @ParameterizedTest
    @DisplayName("Test trim username functionality")
    @CsvSource({
            "Master of Universe!54, masterofuniverse",
            "username, username",
            "!@#$%^&*(), ''",
            "    , ",
            "a b c , abc",
            "null, null",
            " , "
    })
    void givenUsername_whenTrim_thenSuccessResponse(String username, String expected) {
        // when
        String actual = service.trim(username);

        // then
        assertEquals(expected, actual);
    }
}