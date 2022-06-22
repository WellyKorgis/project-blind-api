package com.blind.post.domain;

import com.blind.account.domain.Account;
import com.blind.shared.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post extends BaseEntity {
    @NotBlank(message = "title cannot be blank")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "content cannot be blank")
    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createAt;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Account account;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Bookmark> bookmarks;
    public void add(Bookmark bookmark) {
        bookmark.setPost(this);
        getBookmarks().add(bookmark);
    }

    public Post(String title, String content, Account account) {
        this.title = title;
        this.content = content;
        this.account = account;
    }
}
