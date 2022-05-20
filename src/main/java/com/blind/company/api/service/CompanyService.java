package com.blind.company.api.service;

import com.blind.company.api.dto.response.GetCompanyResponse;

import java.util.UUID;

public interface CompanyService {
    GetCompanyResponse getCompany(UUID id);
}
