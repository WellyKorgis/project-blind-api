package com.blind.company.api.service;

import com.blind.company.api.dto.request.CreateCompanyRequest;
import com.blind.company.api.dto.response.CreateCompanyResponse;
import com.blind.company.api.dto.shared.CompanyDto;
import com.blind.company.api.mapper.CompanyMapper;
import com.blind.company.domain.Company;
import com.blind.company.persistence.respository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper companyMapper)
    {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public CompanyDto getCompany(UUID id) {

        Company company = companyRepository.findById(id).orElse(null);

        if (company == null) return null;

        return companyMapper.companyToDto(company);
    }

    @Override
    public Page<CompanyDto> getCompanyList(Pageable pageable) {
        return companyRepository.findAll(pageable).map(companyMapper::companyToDto);
    }

    @Override
    public CreateCompanyResponse createCompany(CreateCompanyRequest request) {
        Company mappedCompany = companyMapper.dtoToCompany(request);

        if(mappedCompany == null) return null;

        Company savedCompany = companyRepository.save(mappedCompany);

        return companyMapper.companyToCreateCompanyResponse(savedCompany);
    }
}
