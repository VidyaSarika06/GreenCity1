package com.greencity.identity.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "AuditLog")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuditID")
    private Long id;

    @Column(name = "UserID", nullable = false)
    private Long userId;

    @Column(name = "Action", nullable = false, length = 120)
    private String action;

    @Column(name = "Resource", nullable = false, length = 120)
    private String resource;

    @Column(name = "Details", columnDefinition = "JSON")
    private String details;

    @Column(name = "IPAddress", length = 64)
    private String ipAddress;

    @Column(name = "Timestamp", nullable = false)
    private Instant timestamp;

  
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

	
}