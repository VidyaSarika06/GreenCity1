package com.greencity.controller;

import com.greencity.entity.Audit;
import com.greencity.service.AuditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audits")
public class AuditController {

    private final AuditService service;

    public AuditController(AuditService service) {
        this.service = service;
    }

    // ✅ POST – create audit
    @PostMapping
    public Audit createAudit(@RequestBody Audit audit) {
        return service.createAudit(audit);
    }

    // ✅ GET – fetch all audits
    @GetMapping
    public List<Audit> getAllAudits() {
        return service.getAllAudits();
    }
}
