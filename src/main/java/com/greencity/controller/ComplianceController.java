package com.greencity.controller;

import com.greencity.entity.ComplianceRecord;
import com.greencity.service.ComplianceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {

    private final ComplianceService service;

    public ComplianceController(ComplianceService service) {
        this.service = service;
    }

    // ✅ POST – create compliance record
    @PostMapping
    public ComplianceRecord createCompliance(@RequestBody ComplianceRecord record) {
        return service.createCompliance(record);
    }

    // ✅ GET – fetch all compliance records
    @GetMapping
    public List<ComplianceRecord> getAllCompliance() {
        return service.getAllCompliance();
    }
}
