package com.blind.company.domain;

import com.blind.account.domain.Account;
import com.blind.post.domain.Bookmark;
import com.blind.shared.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Company extends BaseEntity {
    @Column(nullable=false)
    private String name;
    @JoinColumn(name="company_category_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private CompanyCategory companyCategory;

    @OneToMany(mappedBy = "account")
    private Set<Account> account = new HashSet<>();

    public void add(Account account) {
        account.setCompany(this);
        getAccount().add(account);
    }
}
