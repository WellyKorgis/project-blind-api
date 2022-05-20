package com.blind.api.mapping;

import com.blind.company.api.dto.response.GetCompanyResponse;
import com.blind.company.api.mapper.CompanyMapper;
import com.blind.company.domain.Company;
import com.blind.company.domain.CompanyCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MappingTests {
    @Test
    public void shouldMapCompanyToDto()
    {
        Company company = new Company("company name", new CompanyCategory("category"));

        GetCompanyResponse companyDto = CompanyMapper.INSTANCE.companyToGetCompanyResponse(company);

        assertNotNull(companyDto);
        assertEquals(companyDto.getName(), company.getName());
        assertEquals(companyDto.getCompanyCategory(), company.getCompanyCategory().getName());
    }
}
