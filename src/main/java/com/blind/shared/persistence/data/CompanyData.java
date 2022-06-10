package com.blind.shared.persistence.data;

import com.blind.company.persistence.respository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CompanyData implements CommandLineRunner {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyData(CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
