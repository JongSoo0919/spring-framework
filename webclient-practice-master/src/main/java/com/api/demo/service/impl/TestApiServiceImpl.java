package com.api.demo.service.impl;

import com.api.demo.domain.test.TestDto;
import com.api.demo.service.ApiService;

import java.util.List;

public class TestApiServiceImpl implements ApiService {
    @Override
    public List<?> getAll() {
        return List.of();
    }

    @Override
    public <T> T getOne(Long id) {
        return (T) new TestDto(1L);
    }
}
