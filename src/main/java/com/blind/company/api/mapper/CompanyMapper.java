package com.blind.company.api.mapper;

import com.blind.company.api.dto.request.CreateCompanyRequest;
import com.blind.company.api.dto.shared.CompanyCategoryDto;
import com.blind.company.api.dto.shared.CompanyDto;
import com.blind.company.domain.Company;
import com.blind.company.domain.CompanyCategory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    CompanyDto companyToDto(Company company);
    Company dtoToCompany(CreateCompanyRequest companyDto);
    CompanyCategoryDto companyCategoryToDto(CompanyCategory companyCategory);
    CompanyCategory dtoToCompanyCategory(CompanyCategoryDto companyCategoryDto);
    List<CompanyDto> companyListToDto(List<Company> companyList);
}
