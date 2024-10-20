package com.username.trimmer.app.controller;

import com.username.trimmer.app.service.UsernameTrimmerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class UsernameTrimmerControllerV1Test {

    @Mock
    private UsernameTrimmerService service;

    @InjectMocks
    private UsernameTrimmerControllerV1 controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Test get trimmer functionality")
    void whenPerformGetTrimmer_thenSuccessResponse() throws Exception {
        // when
        ResultActions result = mockMvc.perform(get("/v1/username/trim"));

        // then
        result.andExpect(status().isOk())
                .andExpect(view().name("trimmer"))
                .andExpect(model().attributeExists("username"));
    }

    @Test
    @DisplayName("Test post trimmer functionality")
    void givenUsername_whenPerformPostTrimmer_thenSuccessResponse() throws Exception {
        // given
        String username = "Master of Universe!54";
        String expected = "masterofuniverse";

        // when
        ResultActions result = mockMvc.perform(post("/v1/username/trim")
                .param("username", username));

        // then
        result.andExpect(status().isOk())
                .andExpect(view().name("trimmer"));
    }
}