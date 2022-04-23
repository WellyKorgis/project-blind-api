package com.blind.api.company.domain;

import com.blind.common.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "companies")
public class Company extends BaseEntity {
    @Column(nullable=false)
    private String name;
    @JoinColumn(name="company_category_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private CompanyCategory companyCategory;
}
