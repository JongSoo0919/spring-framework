package com.api.demo.service;

import com.api.demo.domain.user.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ApiService {
    /**
     * 전체 결과를 반환한다.
     * @return
     */
    List<?> getAll();

    /**
     * {id}에 맞는 결과를 반환한다.
     * @param id
     * @param <T>
     */
    <T> T getOne(Long id);
}
