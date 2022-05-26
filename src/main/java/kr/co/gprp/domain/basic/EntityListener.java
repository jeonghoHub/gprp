package kr.co.gprp.domain.basic;

import static java.time.LocalDateTime.now;

import javax.persistence.PrePersist;

public class EntityListener {
    @PrePersist
    public void prePersist(Object o){
        if(o instanceof  Auditable){
            ((Auditable) o).setCreateDate(now());
            ((Auditable) o).setUpdateDate(now());
        }
    }

}
