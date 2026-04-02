package com.greencity.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "audits")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    private Long officerId;
    private String scope;
    private String findings;
    private String status;
    private LocalDate date;

    // ✅ GETTERS
    public Long getAuditId() {
        return auditId;
    }

    public Long getOfficerId() {
        return officerId;
    }

    public String getScope() {
        return scope;
    }

    public String getFindings() {
        return findings;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    // ✅ SETTERS (THIS FIXES YOUR ERRORS)
    public void setOfficerId(Long officerId) {
        this.officerId = officerId;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}