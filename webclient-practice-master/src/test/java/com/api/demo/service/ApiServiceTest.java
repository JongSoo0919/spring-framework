package com.api.demo.service;

import com.api.demo.domain.test.TestDto;
import com.api.demo.service.impl.TestApiServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApiServiceTest {
    private final ApiService testApiServiceImpl;

    public ApiServiceTest() {
        this.testApiServiceImpl = new TestApiServiceImpl();
    }

    @DisplayName("getAll() 테스트")
    @Test
    public void getAllTest(){
        //given
        int count = 0;

        //when
        List<?> list = testApiServiceImpl.getAll();

        //then
        assertThat(count).isEqualTo(list.size());
    }

    @DisplayName("getOne() 테스트")
    @Test
    public void getOneTest(){
        //given
        TestDto testDto = new TestDto(1L);

        //when
        TestDto dto = testApiServiceImpl.getOne(1L);

        //then
        assertThat(testDto).isEqualTo(dto);
    }
}