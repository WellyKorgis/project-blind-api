package com.blind.company.api.service;

import com.blind.company.api.dto.response.CompanyResponse;
import com.blind.company.api.mapper.CompanyMapper;
import com.blind.company.domain.Company;
import com.blind.company.persistence.respository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service()
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyResponse getCompany(UUID id) {
        Company company = companyRepository.findById(id).orElse(null);

        if (company == null) return null;

        return companyMapper.INSTANCE.companyToDto(company);
    }
}
