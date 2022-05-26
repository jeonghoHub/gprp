package kr.co.gprp.domain.delivery.entity;

import java.util.List;
import java.util.regex.Pattern;
import javax.persistence.*;

import kr.co.gprp.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private AddressType addressType;

    private String requirement;//요청사항

    @OneToOne
    private Delivery delivery;

    @Builder
    public Address(String requirement) {
        AddressValidator.verifyRequirement(requirement);

        this.requirement = requirement;
    }

}
