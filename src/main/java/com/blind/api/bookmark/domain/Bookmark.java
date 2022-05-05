package com.blind.api.bookmark.domain;

import com.blind.api.post.domain.Post;
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
public class Bookmark extends BaseEntity {
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ManyToOne
    private Post postId;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userID;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createAt;
}
