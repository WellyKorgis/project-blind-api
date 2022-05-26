package com.blind.api.controller;

import com.blind.company.api.controller.CompanyController;
import com.blind.company.api.dto.response.CompanyResponse;
import com.blind.company.api.mapper.CompanyMapper;
import com.blind.company.api.service.CompanyService;
import com.blind.company.domain.Company;
import com.blind.company.domain.CompanyCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CompanyController.class)
@ExtendWith(MockitoExtension.class)
public class CompanyControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Mock
    private CompanyMapper companyMapper;

    @Test
    public void getCompany() throws Exception {
        final CompanyCategory companyCategory = new CompanyCategory(UUID.randomUUID(), "CompanyCategory");
        final Company company = new Company(UUID.randomUUID(), "Company", companyCategory);

        final CompanyResponse companyDto = companyMapper.INSTANCE.companyToDto(company);

        given(companyService.getCompany(company.getId())).willReturn(companyDto);

        this.mockMvc.perform(get("/company/{id}", company.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(company.getName())));

        verify(companyService).getCompany(company.getId());
    }
}
