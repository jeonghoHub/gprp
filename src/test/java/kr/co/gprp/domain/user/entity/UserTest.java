package kr.co.gprp.domain.user.entity;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    private User user;

    @Test
    void 회원_이름이_유효하지_않아_예외가_발생했다(){
        assertThatThrownBy(() -> {
            User.builder()
                .name("123_123_123_123_123_123_1")
                .email("kgh225@naver.com")
                .pw("sdf")
                .build();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름이_유효하지_않습니다.");
    }

    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = {" "})
    void 회원_이름이_NULL_이_들어가_예외가_발생했습니다(String arg){
        assertThatThrownBy(() -> {
            User.builder()
                .name(arg)
                .email("kgh225@naver.com")
                .pw("sdf")
                .build();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 비어있을 수 없습니다.");
    }

    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = {" "})
    void 이메일이_비어있어_예외가_발생했습니다(String arg){
        assertThatThrownBy(() -> {
            User.builder()
                .name("name")
                .email(arg)
                .pw("sdf")
                .build();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이메일은 비어있을 수 없습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"kgh2252naver.com","kgh2252@nas.com","kgh2252@@@@@","123@123.com"})
    void 이메일_도메인이_알수없어_예외가_발생했습니다(String arg){
        assertThatThrownBy(() -> {
            User.builder()
                .name("name")
                .email(arg)
                .pw("sdf")
                .build();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("알 수 없는 도메인");
    }
    @ParameterizedTest
    @ValueSource(strings = {"123_123_123_123_123_123_123_123_123_123@naver.com","123_123_123_123_123_123_123_123_123_123@na"})
    void 이메일_길이를_벗어나_예외가_발생했습니다(String arg){
        assertThatThrownBy(() -> {
            User.builder()
                .name("name")
                .email(arg)
                .pw("sdf")
                .build();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이메일이 제한 길이를 벗어났습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567123ea"})
    void 패스워드가_유효하지_않아_예외가_발생했습니다(String arg){
        assertThatThrownBy(() -> {
            User.builder()
                .name("name")
                .email("kgh2252@naver.com")
                .pw(arg)
                .build();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("비번의 길이가 맞지 않습니다.");
    }

    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = {" "})
    void 패스워드가_비어있으면_예외가_발생합니다(String arg){
        assertThatThrownBy(() -> {
            User.builder()
                .name("name")
                .email("kgh225@naver.com")
                .pw(arg)
                .build();
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("비번은 비어있을 수 없습니다.");
    }
}
