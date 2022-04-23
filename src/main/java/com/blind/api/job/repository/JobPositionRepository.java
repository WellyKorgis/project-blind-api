package com.blind.api.job.repository;

import com.blind.api.job.domain.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobPositionRepository extends JpaRepository<JobPosition, Integer> {
    Optional<JobPosition> findById(String id);
}
