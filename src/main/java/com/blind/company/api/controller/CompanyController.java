package com.blind.company.api.controller;

import com.blind.company.api.dto.response.CompanyResponse;
import com.blind.company.api.service.CompanyService;
import com.blind.shared.api.BaseDtoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<? extends BaseDtoResponse> getCompanyById(@RequestParam UUID id)
    {
        CompanyResponse getCompanyResponse = companyService.getCompany(id);

        if(getCompanyResponse != null) return ResponseEntity.status(HttpStatus.OK).body(getCompanyResponse);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseDtoResponse.of(HttpStatus.NO_CONTENT.value(), "Couldn't retrieve company information"));
    }
}
