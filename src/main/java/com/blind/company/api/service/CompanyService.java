package com.blind.company.api.service;

import com.blind.company.api.dto.request.CreateCompanyRequest;
import com.blind.company.api.dto.response.CreateCompanyResponse;
import com.blind.company.api.dto.shared.CompanyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CompanyService {
    CompanyDto getCompany(UUID id);
    Page<CompanyDto> getCompanyList(Pageable pageable);
    CreateCompanyResponse createCompany(CreateCompanyRequest request);
}
