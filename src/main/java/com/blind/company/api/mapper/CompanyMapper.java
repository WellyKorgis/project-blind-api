package com.blind.company.api.mapper;

import com.blind.company.api.dto.response.CompanyCategoryResponse;
import com.blind.company.api.dto.response.CompanyResponse;
import com.blind.company.domain.Company;
import com.blind.company.domain.CompanyCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyResponse companyToDto (Company company);
    CompanyCategoryResponse companyCategoryToDto (CompanyCategory companyCategory);
}
