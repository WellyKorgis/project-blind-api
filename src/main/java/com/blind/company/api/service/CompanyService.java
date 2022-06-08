package com.blind.company.api.service;

import com.blind.company.api.dto.response.CompanyResponse;

import java.util.UUID;

public interface CompanyService {
    CompanyResponse getCompany(UUID id);
}
