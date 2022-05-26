package kr.co.gprp.domain.delivery.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
@Getter
public class AddressType {
    private String roadName;        //도로명
    private String zipCode;         //우편번호
    private String name;            //이름
    private String detailed;        //상세주소

    protected AddressType() {
    }

    @Builder
    public AddressType(String roadName, String zipCode, String name, String detailed) {
        AddressValidator.verifyRoadName(roadName);
        AddressValidator.verifyZipCodes(zipCode);
        AddressValidator.verifyName(name);
        AddressValidator.verifyDetailed(detailed);

        this.roadName = roadName;
        this.zipCode = zipCode;
        this.name = name;
        this.detailed = detailed;
    }

}
