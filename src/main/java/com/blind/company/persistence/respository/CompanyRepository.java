package com.blind.company.persistence.respository;

import com.blind.company.api.dto.response.CreateCompanyResponse;
import com.blind.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
    CreateCompanyResponse saveCompany(Company company);
}
