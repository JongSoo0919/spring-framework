package org.example.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    /*
     * 잘못된 테스트 방법
     * 해당 테스트는 랜덤 패스워드에 대한 의존성을 User객체 내부에서 받고 있기 때문에
     * 의존성을 바꿔줄 수가 없어 테스트가 어렵고, 랜덤 패스워드 특성상 무조건 성공을 보장할 수가 없음.
     * 때문에 이런식으로 테스트가 어려운경우 의존성을 바깥으로 빼내고, Test 패키지에만 있는 무조건 성공을 보장할 수 있는 객체를 만들고,
     * Interface로 의존성을 주입받음으로써 올바른 테스트를 보장할 수 있다.
     */
//    @DisplayName("패스워드를 초기화 한다.")
//    @Test
//    void wrongPasswordTest() {
//        //given
//        User user = new User();
//
//        //when
//        user.initPassword();
//
//        //then
//        assertThat(user.getPassword()).isNotNull();
//    }


    @DisplayName("패스워드를 초기화 한다.")
    @Test
    void passwordTest() {
        //given
        User user = new User();

        //when
        user.initPassword(new CorrectFixedPasswordGenerator());

        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드가 요구사항에 부합하지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() {
        //given
        User user = new User();

        //when
        user.initPassword(new FailedFixedPasswordGenerator());

        //then
        assertThat(user.getPassword()).isNull();
    }
}