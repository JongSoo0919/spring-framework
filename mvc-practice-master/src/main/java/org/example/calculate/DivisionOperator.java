package org.example.calculate;

public class DivisionOperator implements NewArithmaticOperator{
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        //PositiveNumber가 operand가 0이 아님을 무조건 보장하기 때문에, 해당 코드는 의미가 없어짐.
//        if(operand2.toInt() == 0){
//            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
//        }
        return operand1.toInt() / operand2.toInt();
    }
}
