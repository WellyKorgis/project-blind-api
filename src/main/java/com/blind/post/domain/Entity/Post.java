package com.blind.post.domain.Entity;

import com.blind.account.domain.Entity.Account;
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
public class Post extends BaseEntity {
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createAt;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Account user;
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;
}