package com.api.demo.domain.test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class TestDto {
    private final Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestDto testDto = (TestDto) o;
        return Objects.equals(id, testDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
