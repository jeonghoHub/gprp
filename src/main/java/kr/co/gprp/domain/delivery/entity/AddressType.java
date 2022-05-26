package kr.co.gprp.domain.delivery.entity;

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

    // null 가능
    private String requirement;//요청사항
    private String detailed;//상세주소

    protected AddressType() {
    }

    public AddressType(String roadName, String zipCode, String name, String requirement, String detailed) {
        this.roadName = roadName;
        this.zipCode = zipCode;
        this.name = name;
        this.requirement = requirement;
        this.detailed = detailed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressType)) return false;
        AddressType that = (AddressType) o;
        return Objects.equals(getRoadName(), that.getRoadName()) && Objects.equals(getZipCode(), that.getZipCode()) && Objects.equals(getName(), that.getName()) && Objects.equals(getRequirement(), that.getRequirement()) && Objects.equals(getDetailed(), that.getDetailed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoadName(), getZipCode(), getName(), getRequirement(), getDetailed());
    }
}
