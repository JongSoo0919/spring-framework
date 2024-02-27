package org.example.calculate.tobe;

import org.example.calculate.domain.PositiveNumber;

public interface ArithmeticOperator {
    /***
     * 해당 오퍼레이터를 지원하는지
     * @param operator
     * @return
     */
    boolean supports(String operator);

    /***
     * 실제 계산
     * @param operand1
     * @param operand2
     * @return
     */
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
