package com.greencity.notification.api;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.greencity.notification.app.NotificationService;
import com.greencity.notification.domain.Notification;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public Notification create(@RequestBody Notification notification) {
        return service.create(notification);
    }

    @GetMapping("/{userId}")
    public List<Notification> getByUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }

    @GetMapping
    public List<Notification> getAll() {
        return service.getAll();
    }

    @PutMapping("/read/{id}")
    public Notification markAsRead(@PathVariable Long id) {
        return service.markAsRead(id);
    }
}
