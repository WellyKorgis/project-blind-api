package com.blind.api.comment.domain;

import com.blind.api.user.domain.User;
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
@Table(name = "comments")
public class Comment extends BaseEntity {
    @Column(nullable = false)
    private String content;

    @Column(name = "is_writer", nullable = false)
    private boolean isWriter;

    @JoinColumn(name= "user_id", nullable = false)
    @ManyToOne
    private User userId;

    @Column(name = "is_updated", nullable = true)
    private boolean isUpdated;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;
}