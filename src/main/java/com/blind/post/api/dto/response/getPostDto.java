package com.blind.post.api.dto.response;

import com.blind.account.domain.Account;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class getPostDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("createdAt")
    private OffsetDateTime createAt;

    @JsonProperty("createdBy")
    private Account account;
}
