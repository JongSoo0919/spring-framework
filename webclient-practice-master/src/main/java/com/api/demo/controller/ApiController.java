package com.api.demo.controller;

import com.api.demo.domain.user.UserDto;
import com.api.demo.service.ApiService;
import com.api.demo.util.Constant;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiController {
    private final ApiService jsonPlaceHolderApiService;

    @GetMapping("/api/users")
    public ResponseEntity<List<UserDto>> requestUsersApi(HttpServletRequest request){
        log.info("{} {} 진입", request.getRequestURL(), request.getMethod());
        List<UserDto> list = (List<UserDto>) jsonPlaceHolderApiService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<UserDto> requestUserApi(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
        log.info("{} {} 진입", request.getRequestURL(), request.getMethod());
        UserDto userDto = (UserDto) jsonPlaceHolderApiService.getOne(id);

        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/api/test")
    public ResponseEntity<?> test(
            HttpServletRequest request
    ){
        log.info("{} {} 진입", request.getRequestURL(), request.getMethod());

        WebClient webClient = WebClient.create(Constant.JSON_PLACEHOLDER_USER_API_URL+Constant.JSON_PLACEHOLDER_USER_API_URI);
        List<UserDto> list = webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(UserDto.class)
                .collectList()
                .block();

        WebClient webClient2 = WebClient.create(Constant.JSON_PLACEHOLDER_USER_API_URL+Constant.JSON_PLACEHOLDER_USER_API_URI+"/1");
        UserDto userDto = webClient2.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();

        System.out.println(list.toString());
        System.out.println(userDto.toString());
        return ResponseEntity.ok("");
    }
}
