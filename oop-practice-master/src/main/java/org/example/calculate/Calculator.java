package org.example.calculate;

import org.example.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmaticOperator> arithmaticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2){
        return arithmaticOperators.stream()
                .filter(arithmaticOperators -> arithmaticOperators.supports(operator))
                .map(arithmaticOperators -> arithmaticOperators.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
//    public static int calculate(int operand1, String operator, int operand2){
//        return ArithmaticOperator.calculate(operand1, operator, operand2);
//    }
}
