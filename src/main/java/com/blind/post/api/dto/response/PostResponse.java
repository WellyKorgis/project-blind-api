package com.blind.post.api.dto.response;

import com.blind.account.domain.Account;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class PostResponse {
    @JsonProperty("title")
    private String title;

    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonProperty("created_by")
    private Account account;
}
