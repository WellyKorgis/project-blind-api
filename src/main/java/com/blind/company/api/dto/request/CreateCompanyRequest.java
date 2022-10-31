package com.blind.company.api.dto.request;

import com.blind.company.api.dto.shared.CompanyCategoryDto;
import com.blind.shared.api.BaseEntityDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompanyRequest extends BaseEntityDto {
    private String name;
    private CompanyCategoryDto companyCategory;

    @Builder
    public CreateCompanyRequest(String id, String name, CompanyCategoryDto companyCategory)
    {
        super(id);
        this.name = name;
        this.companyCategory = companyCategory;
    }
}
