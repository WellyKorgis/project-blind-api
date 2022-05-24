package com.blind.account.domain;

import com.blind.post.domain.Bookmark;
import com.blind.shared.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Account extends BaseEntity {
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createAt;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Bookmark> bookmarks;
}
