package org.example.password;

import org.example.password.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/*

    - 요구사항
        1. 비밀번호는 최소 8자 이상 12자 이하
        2. 비밀번호가 8자 미만, 12자 초과인 경우 IllegalArgumentException 예외 발생
        3. 경계조건에 대해 테스트 코드를 작성해야함.
 */
public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatorPasswordTest(){
        assertThatCode(() -> PasswordValidator.validate("12345678"))
                .doesNotThrowAnyException();

    }

    @DisplayName("비밀번호가 8자 미만, 12자 초과 하는 경우 IllegalArgumentException 발생")
    @Test
    void validatorPasswordTest2(){
        assertThatCode(() -> PasswordValidator.validate("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PasswordValidator.WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
    }

    @DisplayName("경계값 테스트란, 8자 미만 : 7자, 12자 초과 : 13자 라는 경계 값에 대한 테스트 코드가 필요하다")
    @ParameterizedTest
    @ValueSource(strings = {"1234567","1234567890123"})
    void validatorPasswordTest3(String password){
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PasswordValidator.WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
    }

}
