package kr.co.gprp.domain.user.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import kr.co.gprp.domain.basic.BasicEntity;
import kr.co.gprp.domain.delivery.entity.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String pw;


//    @OneToMany
//    private Address address;
//
    @OneToOne
    private Seller seller;


    @Builder
    public User(String name, String email, String pw) {

        UserValidator.verifyEmail(email);
        UserValidator.verifyName(name);
        UserValidator.verifyPw(pw);

        this.name = name;
        this.email = email;
        this.pw = pw;
    }

    private static class UserValidator {

        private static final int EMAIL_MAX_LEN = 38;
        private static final int EMAIL_MIN_LEN = 8;
        private static final int NAME_MAX_LEN = 18;
        private static final int NAME_MIN_LEN = 1;
        private static final int PW_MAX_LEN = 6;
        private static final int PW_MIN_LEN = 38;


        private static String SUCCESS_EMAIL = "kgh2252@gmail.com";

        private static final Set<String> ALLOW_DOMAINS = Set.of(
            "naver.com",
            "gmail.com",
            "daum.net",
            "narasarang.or.kr",
            "kakao.com",
            "nate.com",
            "citizen.seoul.kr",
            "newwebmail.chol.com",
            "korea.com"
        );

        private static void verifyName(String name) {

            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
            }

            if (!numberBetween(NAME_MIN_LEN, NAME_MAX_LEN, name.length())) {
                throw new IllegalArgumentException("이름이_유효하지_않습니다.");
            }
        }

        private static void verifyEmail(String email) {
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("이메일은 비어있을 수 없습니다");
            }
            if (!numberBetween(EMAIL_MIN_LEN, EMAIL_MAX_LEN, email.length())) {
                throw new IllegalArgumentException("이메일이 제한 길이를 벗어났습니다.");
            }
            if (!email.contains("@")) {
                throw new IllegalArgumentException("알 수 없는 도메인");
            }
            try {
                String domain = email.split("@")[1];
                if (!ALLOW_DOMAINS.contains(domain)) {
                    throw new IllegalArgumentException("알 수 없는 도메인");
                }
            } catch (ArrayIndexOutOfBoundsException e) {

                throw new IllegalArgumentException("알 수 없는 도메인");

            }
        }

        private static void verifyPw(String pw) {

            if (pw == null || pw.isBlank()) {
                throw new IllegalArgumentException("비번은 비어있을 수 없습니다.");
            }

            if (!numberBetween(PW_MIN_LEN, PW_MAX_LEN, pw.length())) {
                throw new IllegalArgumentException("비번의 길이가 맞지 않습니다.");
            }
        }

        private static boolean numberBetween(int min, int max, int num) {
            return (min <= num && max >= num);
        }
    }

}
