package com.blind.api.user.domain;

import com.blind.common.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User extends BaseEntity {
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    //TODO: Put it back when company, job position is added
//    @Column(name = "company_id")
//    private UUID companyId;
//
//    @Column(name = "job_position_id")
//    private UUID jobPositionId;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createAt;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;
}
