package com.blind.api.controller;

import com.blind.company.api.controller.CompanyController;
import com.blind.company.api.dto.response.CompanyResponse;
import com.blind.company.api.mapper.CompanyMapper;
import com.blind.company.api.service.CompanyService;
import com.blind.company.domain.Company;
import com.blind.company.domain.CompanyCategory;
import com.blind.shared.api.BaseDtoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CompanyControllerTests {
    @Mock
    private CompanyService companyService;

    @Mock
    private CompanyMapper companyMapper;

    @InjectMocks
    private CompanyController companyController;

    @Test
    public void getCompany() throws Exception {
        final CompanyCategory companyCategory = new CompanyCategory();
        final Company company = new Company();

        companyCategory.setId(UUID.randomUUID());
        companyCategory.setName("CompanyCategory");

        company.setId(UUID.randomUUID());
        company.setName("Company");
        company.setCompanyCategory(companyCategory);

        final CompanyResponse companyDto = companyMapper.INSTANCE.companyToDto(company);

        given(companyService.getCompany(company.getId())).willReturn(companyDto);

        ResponseEntity<? extends BaseDtoResponse> response = companyController.getCompanyById(company.getId());

        ObjectMapper mapper = new ObjectMapper();
        var responseToGetCompanyResponse = mapper.convertValue(response.getBody(), CompanyResponse.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(companyDto.getName(), responseToGetCompanyResponse.getName());

        verify(companyService).getCompany(companyDto.getId());
    }
}
