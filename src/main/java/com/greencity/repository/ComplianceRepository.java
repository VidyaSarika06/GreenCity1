package com.greencity.repository;

import com.greencity.entity.ComplianceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplianceRepository
        extends JpaRepository<ComplianceRecord, Long> {
}