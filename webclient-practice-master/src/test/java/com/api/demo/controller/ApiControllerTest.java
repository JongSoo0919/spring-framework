package com.api.demo.controller;

import com.api.demo.service.impl.TestApiServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {
    private final MockMvc mvc;
    public ApiControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("/api/users 호출")
    @Test
    public void getUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @DisplayName("/api/users/{id} 호출")
    @Test
    public void getUser() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/users/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}