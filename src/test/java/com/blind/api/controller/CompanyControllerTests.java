package com.blind.api.controller;

import com.blind.company.api.controller.CompanyController;
import com.blind.company.api.dto.request.CreateCompanyRequest;
import com.blind.company.api.dto.response.CreateCompanyResponse;
import com.blind.company.api.dto.shared.CompanyCategoryDto;
import com.blind.company.api.dto.shared.CompanyDto;
import com.blind.company.api.mapper.CompanyMapper;
import com.blind.company.api.service.CompanyService;
import com.blind.company.domain.Company;
import com.blind.company.domain.CompanyCategory;
import com.blind.post.api.mapper.PostMapper;
import com.blind.post.api.service.PostService;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Log4j
@WebMvcTest(controllers = CompanyController.class)
@ExtendWith(MockitoExtension.class)
public class CompanyControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Mock
    private CompanyMapper companyMapper;

    @Mock
    private PostService postService;

    @Mock
    private PostMapper postMapper;

    @Test
    public void getCompany() throws Exception {
        final CompanyCategory companyCategory = new CompanyCategory(UUID.randomUUID(), "CompanyCategory");
        final Company company = new Company(UUID.randomUUID(), "Company", companyCategory);

        final CompanyDto companyDto = companyMapper.INSTANCE.companyToDto(company);

        given(companyService.getCompany(company.getId())).willReturn(companyDto);

        this.mockMvc.perform(get("/companies/{id}", company.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(company.getName())));

        verify(companyService).getCompany(company.getId());
    }

    @Test
    public void getCompanyList() throws Exception {

        final CompanyCategory companyCategory = new CompanyCategory(UUID.randomUUID(), "CompanyCategory");

        final List<Company> companyList = new ArrayList<>();

        companyList.add(new Company(UUID.randomUUID(), "Company1", companyCategory));
        companyList.add(new Company(UUID.randomUUID(), "Company2", companyCategory));
        companyList.add(new Company(UUID.randomUUID(), "Company3", companyCategory));

        final List<CompanyDto> companyResponses = companyMapper.INSTANCE.companyListToDto(companyList);

        Pageable pageable = PageRequest.of(0, 20);
        Page<CompanyDto> pagedResponses = new PageImpl<>(companyResponses);

        given(companyService.getCompanyList(pageable)).willReturn(pagedResponses);

        this.mockMvc.perform(get("/companies"))
                .andExpect(jsonPath("$.content.[0].name", is("Company1")))
                .andExpect(jsonPath("$.content.[1].name", is("Company2")))
                .andExpect(jsonPath("$.content.[2].name", is("Company3")))
                .andExpect(status().isOk());

        verify(companyService).getCompanyList(pageable);
    }

    @Test
    public void createCompany() throws Exception {
        final CompanyCategoryDto companyCategory = new CompanyCategoryDto(UUID.randomUUID(), "CompanyCategory");
        final CompanyDto company = new CompanyDto(UUID.randomUUID(), "Company", companyCategory);

        final CreateCompanyRequest request = new CreateCompanyRequest(company.getId().toString(), company.getName(), company.getCompanyCategory());

        final CreateCompanyResponse response = new CreateCompanyResponse(request.getId());

        var requestBody = new Gson().toJson(request);

        given(companyService.createCompany(any(CreateCompanyRequest.class))).willReturn(response);

        this.mockMvc.perform(post("/companies")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(request.getId())));
    }
}
