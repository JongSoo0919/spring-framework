package com.api.demo.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Geo {
    private String lat;
    private String lng;
}
