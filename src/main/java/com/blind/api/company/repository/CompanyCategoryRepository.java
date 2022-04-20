package com.blind.api.company.repository;

import com.blind.api.company.domain.CompanyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyCategoryRepository extends JpaRepository<CompanyCategory, Integer> {
    Optional<CompanyCategory> findById(String id);
}
