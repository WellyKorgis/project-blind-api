package com.blind.account.domain.Entity;

import com.blind.company.domain.Entity.JobPosition;
import com.blind.company.domain.Entity.Company;
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
public class Account extends BaseEntity {
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
