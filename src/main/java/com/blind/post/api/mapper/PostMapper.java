package com.blind.post.api.mapper;

import com.blind.post.api.dto.response.PostResponse;
import com.blind.post.domain.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PostMapper {
    PostResponse postToDto (Post post);
    List<PostResponse> postListToDto(List<Post> postList);
}
