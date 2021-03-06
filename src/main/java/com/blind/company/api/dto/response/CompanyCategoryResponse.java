package com.blind.company.api.dto.response;

import com.blind.shared.api.BaseDtoResponse;
import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyCategoryResponse extends BaseDtoResponse {
    private UUID id;
    private String name;
}
