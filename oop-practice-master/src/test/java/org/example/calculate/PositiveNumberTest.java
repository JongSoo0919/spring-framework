package org.example.calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PositiveNumberTest {
    @DisplayName("PostivieNumber 객체는 0또는 음수가 들어올 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0,-1})
    void createTest(){
        assertThatCode(() -> new PositiveNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0또는 음수를 전달할 수 없습니다.");
    }
}