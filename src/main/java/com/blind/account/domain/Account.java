package com.blind.account.domain;

import com.blind.post.domain.Bookmark;
import com.blind.post.domain.Post;
import com.blind.shared.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.awt.print.Book;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Account extends BaseEntity {
    @Column(nullable = false)
    @NotEmpty(message = "Please provide a username")
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "Please provide an email address")
    private String email;

    @Column(nullable = false)
    @NotEmpty(message = "Please provide a password")
    private String password;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createAt;

    @Column(name = "is_activated", nullable = false)
    private boolean isActivated;

    @OneToMany(mappedBy = "account")
    private Set<Bookmark> bookmarks = new HashSet<>();

    public void add(Bookmark bookmark) {
        bookmark.setAccount(this);
        getBookmarks().add(bookmark);
    }

    @OneToMany(mappedBy = "account")
    private Set<Post> posts = new HashSet<>();

    public void add(Post post) {
        post.setAccount(this);
        getPosts().add(post);
    }

    public Account(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
