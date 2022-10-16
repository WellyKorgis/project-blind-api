package com.blind.company.api.controller;

import com.blind.company.api.dto.request.CreateCompanyRequest;
import com.blind.company.api.dto.response.CreateCompanyResponse;
import com.blind.company.api.dto.shared.CompanyDto;
import com.blind.company.api.service.CompanyService;
import com.blind.shared.api.BaseDtoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends BaseDtoResponse> getCompanyById(@PathVariable("id") UUID id)
    {
        CompanyDto getCompanyResponse = companyService.getCompany(id);

        if(getCompanyResponse != null) return ResponseEntity.status(HttpStatus.OK).body(getCompanyResponse);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseDtoResponse.of(HttpStatus.NO_CONTENT.value(), "Couldn't retrieve company information"));
    }

    @GetMapping
    public ResponseEntity<?> getCompanyList(Pageable pageable)
    {
        Page<CompanyDto> getCompanyList = companyService.getCompanyList(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(getCompanyList);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<? extends BaseDtoResponse> create(@RequestBody CreateCompanyRequest request)
    {
        CreateCompanyResponse response = companyService.createCompany(request);

        if(response != null) return ResponseEntity.status(HttpStatus.CREATED).body(response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseDtoResponse.of(HttpStatus.BAD_REQUEST.value(), "Couldn't create a company"));
    }
}
