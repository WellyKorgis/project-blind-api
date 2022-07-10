package com.blind.company.api.service;

import com.blind.company.api.dto.response.CompanyResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CompanyService {
    CompanyResponse getCompany(UUID id);
    Page<CompanyResponse> getCompanyList(Pageable pageable);
}
