package com.api.demo.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
