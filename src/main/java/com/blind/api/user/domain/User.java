package com.blind.api.user.domain;

import com.blind.api.job.domain.JobPosition;
import com.blind.api.company.domain.Company;
import com.blind.common.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;

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
  
    @JoinColumn(name = "job_position_id", referencedColumnName = "id")
    @ManyToOne
    private JobPosition jobPosition;

    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Company company;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createAt;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;
}
