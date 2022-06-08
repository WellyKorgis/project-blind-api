package com.blind.company.domain;

import com.blind.shared.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class JobPosition extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @JoinColumn(name="job_category_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private JobCategory jobCategory;
}