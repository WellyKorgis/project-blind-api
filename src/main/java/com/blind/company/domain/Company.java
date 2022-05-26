package com.blind.company.domain;

import com.blind.shared.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Company extends BaseEntity {
    @Column(nullable=false)
    private String name;

    @JoinColumn(name="company_category_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private CompanyCategory companyCategory;

    @Builder
    public Company(UUID id, String name, CompanyCategory companyCategory)
    {
        super(id);
        this.name = name;
        this.companyCategory = companyCategory;
    }
}
