package kr.co.gprp.domain.delivery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Delivery {

    private enum Status {
        INSTRUCT,       //상품준비중
        DEPARTURE,      //배송지시
        FINAL_DELIVERY, //배송중
        NONE_TRACKING ,  //배송완료
        ACCEPT         //결제완료
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Status status;


    @OneToOne
    private Address address;
//   System.out.println(status.ordinal()); //enum 순서

    @Builder
    public Delivery(Status status) {
        this.status = status;
    }

}
