package kr.co.gprp.domain.basic;


import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreatedDate();
    LocalDateTime getUpdatedDate();

    void setCreateDate(LocalDateTime createDate);
    void setUpdateDate(LocalDateTime updateDate);

}
