package com.dev.utilizationmanagement.repository;

import com.dev.utilizationmanagement.entity.ResourceUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceUsageRepository extends JpaRepository<ResourceUsage, Long> {
}
