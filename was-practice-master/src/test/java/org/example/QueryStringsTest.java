package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QueryStringsTest {
    // 쿼리스트링이 여러개라면, QueryString 객체를 여러개 가질 수 있는 List를 일급 객체로 생성
    @DisplayName("쿼리 스트링이 여러개 일 때")
    @Test
    void createTest(){
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=+&operand2=55");

        Assertions.assertThat(queryStrings).isNotNull();
    }
}
