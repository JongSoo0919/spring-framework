package com.api.demo.service.impl;

import com.api.demo.domain.user.UserDto;
import com.api.demo.service.ApiService;
import com.api.demo.util.Constant;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class JsonPlaceholderApiServiceImpl implements ApiService {

    private final WebClient webClient;

    public JsonPlaceholderApiServiceImpl() {
        this.webClient = WebClient.create(Constant.JSON_PLACEHOLDER_USER_API_URL);
    }

    @Override
    public List<?> getAll() {
        return webClient.get()
                .uri(Constant.JSON_PLACEHOLDER_USER_API_URI)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(List.class)
                .block();
    }

    @Override
    public <T> T getOne(Long id) {
        return (T) webClient.get()
                .uri(Constant.JSON_PLACEHOLDER_USER_API_URI + "/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }
}
