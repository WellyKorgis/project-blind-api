package com.blind;

import com.blind.company.domain.CompanyCategory;
import com.blind.company.persistence.respository.CompanyCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BlindApplication implements CommandLineRunner {
    @Autowired
    CompanyCategoryRepository ccRepo;
    public static void main(String... args) {
        SpringApplication.run(BlindApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ccRepo.saveAll(List.of(
                new CompanyCategory("Hospitality"),
                new CompanyCategory("IT")
            )
        );
        System.out.println("data inserted");
    }
}
