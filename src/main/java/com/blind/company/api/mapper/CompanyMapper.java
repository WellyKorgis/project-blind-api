package com.blind.company.api.mapper;

import com.blind.company.api.dto.response.GetCompanyResponse;
import com.blind.company.domain.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    GetCompanyResponse companyToGetCompanyResponse(Company company);
}
