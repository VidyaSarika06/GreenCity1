package com.greencity.service;

import com.greencity.entity.Audit;
import com.greencity.repository.AuditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuditService {

    private final AuditRepository repository;

    public AuditService(AuditRepository repository) {
        this.repository = repository;
    }

    public Audit createAudit(Audit audit) {
        audit.setDate(LocalDate.now());
        return repository.save(audit);
    }

    // ✅ THIS METHOD MUST EXIST
    public List<Audit> getAllAudits() {
        return repository.findAll();
    }
}