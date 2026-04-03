package com.greencity.sustainabilityproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "impacts")
public class Impact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long impactId;

    private Long projectId;
    private String metricsJson;
    private LocalDate date;
    private String status;

    // ✅ CORRECT GETTERS & SETTERS

    public Long getImpactId() {
        return impactId;
    }

    public void setImpactId(Long impactId) {
        this.impactId = impactId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getMetricsJson() {
        return metricsJson;
    }

    public void setMetricsJson(String metricsJson) {
        this.metricsJson = metricsJson;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
