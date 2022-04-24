package com.blind.api.tag.repository;

import com.blind.api.post.domain.Post;
import com.blind.api.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
}