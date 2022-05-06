package com.blind.company.persistence.respository;

import com.blind.company.domain.Entity.CompanyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyCategoryRepository extends JpaRepository<CompanyCategory, Integer> {
    Optional<CompanyCategory> findById(String id);
}
