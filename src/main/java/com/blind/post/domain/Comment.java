package com.blind.post.domain;
import com.blind.account.domain.Account;
import com.blind.shared.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment extends BaseEntity {
    private String content;

    @Column(name = "is_writer", nullable = false)
    private boolean isWriter;

    @Column(name = "is_updated", nullable = false)
    private boolean isUpdated;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Account account;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Post post;
}
