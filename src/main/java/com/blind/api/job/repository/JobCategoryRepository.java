package com.blind.api.job.repository;

import com.blind.api.job.domain.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer> {
    Optional<JobCategory> findById(String id);
}
