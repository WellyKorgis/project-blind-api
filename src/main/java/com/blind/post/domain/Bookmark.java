package com.blind.post.domain;

import com.blind.account.domain.Account;
import com.blind.shared.domain.BaseEntity;
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
public class Bookmark extends BaseEntity {
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ManyToOne
    private Post post;

    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @ManyToOne
    private Account account;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createAt;
}
