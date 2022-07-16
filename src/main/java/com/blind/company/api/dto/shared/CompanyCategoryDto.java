package com.blind.company.api.dto.shared;

import com.blind.shared.api.BaseDtoResponse;
import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyCategoryDto extends BaseDtoResponse {
    private UUID id;
    private String name;
}
