package com.blind.company.api.dto.response;

import com.blind.shared.api.BaseDtoResponse;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponse extends BaseDtoResponse {
    private UUID id;
    private String name;
    private CompanyCategoryResponse companyCategory;
}