package com.blind.company.domain;

import com.blind.shared.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CompanyCategory extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="companyCategory")
    private Set<Company> companies;

    @Builder
    public CompanyCategory(UUID id, String name) {
        super(id);
        this.name = name;

    }
}