package com.greencity.identity.domain;

import jakarta.persistence.*;
import java.time.Instant;

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

  // In MySQL you used JSON; simplest mapping is String columnDefinition=JSON
  @Column(name = "Details", columnDefinition = "JSON")
  private String details;

  @Column(name = "IPAddress", length = 64)
  private String ipAddress;

  @Column(name = "Timestamp", nullable = false)
  private Instant timestamp;

  // getters & setters...
}
