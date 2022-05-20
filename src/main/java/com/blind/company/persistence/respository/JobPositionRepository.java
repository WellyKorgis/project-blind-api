package com.blind.company.persistence.respository;

import com.blind.company.domain.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, UUID> {
    Optional<JobPosition> findById(UUID id);
}
