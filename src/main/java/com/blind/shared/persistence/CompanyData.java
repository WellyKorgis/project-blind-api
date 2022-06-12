package com.blind.shared.persistence;

import com.blind.company.domain.Company;
import com.blind.company.persistence.respository.CompanyRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Component
public class CompanyData implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CompanyData.class);
    private final String filePath = "/company-data.json";

    private final CompanyRepository companyRepository;
    private final Environment environment;

    @Autowired
    public CompanyData(CompanyRepository companyRepository, Environment environment) {

        this.companyRepository = companyRepository;
        this.environment = environment;
    }

    @Override
    public void run(String... args) throws Exception {
        if (environment == null) {
            throw new RuntimeException("Environment has not been set yet");
        }

        if(companyRepository.count() > 0) return;

        if (Arrays.stream(environment.getActiveProfiles()).anyMatch(env -> env.equalsIgnoreCase("dev"))) {
            logger.info("Storing companies data");

            companyRepository.saveAll(readCompanyDataFromJson());
        }
    }

    private List<Company> readCompanyDataFromJson() throws IOException {
        try (InputStream is = CompanyData.class.getResourceAsStream(filePath)) {
            if (is == null) throw new IOException("filePath is not found");

            ObjectMapper mapper = new ObjectMapper();

            List<Company> companies = mapper.readValue(is, new TypeReference<>() {
            });

            if (companies.isEmpty()) {
                throw new IllegalArgumentException("Companies data is empty");
            }

            logger.info("# of companies: {}", (long) companies.size());

            return companies;
        }
    }
}
