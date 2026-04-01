package com.greencity.notification.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

/*@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotificationID")
    private Long id;

    @Column(name = "UserID")
    private Long userId;

    @Column(name = "ProjectID")
    private Long projectId;

    @Column(name = "ResourceID")
    private Long resourceId;

    @Column(name = "Message")
    private String message;

    @Column(name = "Category")
    private String category;

    @Column(name = "Status")
    private String status;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    public Notification() {}

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }*/
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notificationid") 
    private Long id;

    @Column(name = "UserID")
    private Long userId; 

    @Column(name = "ProjectID")
    private Long projectId;

    @Column(name = "ResourceID")
    private Long resourceId;

    @Column(name = "Message")
    private String message;
    
    @Column(name = "Category")
    private String category;
    
    @Column(name = "Status")
    private String status;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

  



    // Getters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getProjectId() { return projectId; }
    public Long getResourceId() { return resourceId; }
    public String getMessage() { return message; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setUserId(Long userId) { this.userId = userId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public void setResourceId(Long resourceId) { this.resourceId = resourceId; }
    public void setMessage(String message) { this.message = message; }
    public void setCategory(String category) { this.category = category; }
    public void setStatus(String status) { this.status = status; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}