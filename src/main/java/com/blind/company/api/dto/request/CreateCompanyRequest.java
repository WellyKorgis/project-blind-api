package com.blind.company.api.dto.request;

import com.blind.company.api.dto.shared.CompanyCategoryDto;

import java.util.UUID;

public class CreateCompanyRequest {
    private UUID id;
    private String name;
    private CompanyCategoryDto companyCategory;
}
