package org.example.gradecalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * - 요구사항
 *     1. 평균학점 계산 방법 = (학점수 * 교과목 평점)의 합계 / 수강신청 총 학점 수
 *     2. 일급 컬렉션 사용
 */

// 1. 도메인을 구성하는 객체 고민 : 이수한 과목, 학점 계산기
// 2. 객체들간의 관계 고민 : 이수한 과목을 통해 학점 계산이 가능한가
// 3. 동적인 객체를 정적인 타입으로 추상화 : 과목(코스)라는 클래스로 표현
// 4. 협력 설계
// 5. 이수한 과목을 전달하여 평균학점 계산 요청 -> 학점계산기에게
// 6. 구현
public class GradeCalculatorTest {

    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest(){
        List<Course> courses = List.of(new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculateGrade();
        assertThat(gradeResult).isEqualTo(4.5);

    }
}
