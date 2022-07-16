package com.blind.company.api.dto.shared;

import com.blind.shared.api.BaseDtoResponse;
import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto extends BaseDtoResponse {
    private UUID id;
    private String name;
    private CompanyCategoryDto companyCategory;
}