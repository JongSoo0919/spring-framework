package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class QueryStringTest {

    // operand1=11
    @DisplayName("쿼리 스트링이 하나일 때")
    @Test
    void createTest(){
        QueryString queryString = new QueryString("operand1","11");

        assertThat(queryString).isNotNull();

    }
}
