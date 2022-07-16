package com.blind.api.mapping;

import com.blind.company.api.dto.shared.CompanyDto;
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
        CompanyCategory companyCategory = new CompanyCategory(UUID.randomUUID(), "CompanyCategory");
        Company company = new Company(UUID.randomUUID(), "Company", companyCategory);

        CompanyDto companyDto = companyMapper.INSTANCE.companyToDto(company);

        assertNotNull(companyDto);
        assertEquals(companyDto.getName(), company.getName());
        assertEquals(companyDto.getCompanyCategory().getName(), company.getCompanyCategory().getName());
    }
}
