package com.greencity.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "compliance_records")
public class ComplianceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complianceId;

    private Long entityId;

    @Enumerated(EnumType.STRING)
    private ComplianceType type;

    private String result;
    private String notes;
    private LocalDate date;

    // ✅ GETTERS
    public Long getComplianceId() {
        return complianceId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public ComplianceType getType() {
        return type;
    }

    public String getResult() {
        return result;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getDate() {
        return date;
    }

    // ✅ SETTERS (THIS FIXES ERRORS)
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public void setType(ComplianceType type) {
        this.type = type;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}