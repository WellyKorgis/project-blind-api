package com.blind.company.api.mapper;

import com.blind.company.api.dto.response.CompanyResponse;
import com.blind.company.domain.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyResponse companyToGetCompanyResponse(Company company);
}
