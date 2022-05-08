package com.blind.company.domain;

import com.blind.shared.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CompanyCategory extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
