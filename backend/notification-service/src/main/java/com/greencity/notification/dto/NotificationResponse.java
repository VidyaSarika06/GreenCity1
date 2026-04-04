package com.greencity.notification.dto;

import java.time.LocalDateTime;

public class NotificationResponse {
	private Long id;
    private String message;
    private String category;
    private String status;
    private LocalDateTime createdAt;

    // Constructor must match the 5 fields used in the Controller
    public NotificationResponse(Long id, String message, String category, String status, LocalDateTime createdAt) {
        this.id = id;
        this.message = message;
        this.category = category;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters
    public Long getId() { return id; }
    public String getMessage() { return message; }
    public String getCategory() { return category; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedDate() { return createdAt; }
}