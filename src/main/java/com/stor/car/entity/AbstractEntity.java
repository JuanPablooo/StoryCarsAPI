package com.stor.car.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Date createAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private Date updateAt;

    @PrePersist
    protected void prePersist() {
        if (this.createAt == null) createAt = new Date();
        if (this.updateAt == null) updateAt = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updateAt = new Date();
    }


}
