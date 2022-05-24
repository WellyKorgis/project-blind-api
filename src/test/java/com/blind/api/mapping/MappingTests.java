package com.blind.api.mapping;

import com.blind.company.api.dto.response.CompanyResponse;
import com.blind.company.api.mapper.CompanyMapper;
import com.blind.company.domain.Company;
import com.blind.company.domain.CompanyCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class MappingTests {
    @Mock
    private CompanyMapper companyMapper;

    @Test
    public void shouldMapCompanyToDto() throws Exception
    {
        CompanyCategory companyCategory = new CompanyCategory();
        Company company = new Company();

        companyCategory.setId(UUID.randomUUID());
        companyCategory.setName("CompanyCategory");

        company.setId(UUID.randomUUID());
        company.setName("Company");
        company.setCompanyCategory(companyCategory);

        CompanyResponse companyDto = companyMapper.INSTANCE.companyToDto(company);

        assertNotNull(companyDto);
        assertEquals(companyDto.getName(), company.getName());
        assertEquals(companyDto.getCompanyCategory().getName(), company.getCompanyCategory().getName());
    }
}