package org.example.calculate.domain;

import org.example.calculate.tobe.*;

import java.util.List;

public class Calculator {
    private static final List<ArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2){
        return arithmeticOperators.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
//    public static int calculate(int operand1, String operator, int operand2){
//        return ArithmaticOperator.calculate(operand1, operator, operand2);
//    }
}
