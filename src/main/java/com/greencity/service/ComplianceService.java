package com.greencity.service;

import com.greencity.entity.ComplianceRecord;
import com.greencity.repository.ComplianceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComplianceService {

    private final ComplianceRepository repository;

    public ComplianceService(ComplianceRepository repository) {
        this.repository = repository;
    }

    public ComplianceRecord createCompliance(ComplianceRecord record) {
        record.setDate(LocalDate.now());
        return repository.save(record);
    }

    public List<ComplianceRecord> getAllCompliance() {
        return repository.findAll();
    }
}