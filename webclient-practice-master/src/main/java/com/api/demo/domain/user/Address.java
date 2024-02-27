package com.api.demo.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}
