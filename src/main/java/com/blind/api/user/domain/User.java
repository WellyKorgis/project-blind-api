package com.blind.api.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue()
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(name="company_id")
    private UUID companyId;

    @Column(name="job_position_id")
    private UUID jobPositionId;

    @CreatedDate
    @Column(name="created_at")
    private OffsetDateTime createAt;

    @Column(name="is_activated", nullable = false)
    private boolean isActivated;
}
