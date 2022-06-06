package com.blind.company.persistence.respository;

import com.blind.company.domain.CompanyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyCategoryRepository extends JpaRepository<CompanyCategory, UUID> {
    Optional<CompanyCategory> findById(UUID id);
}
