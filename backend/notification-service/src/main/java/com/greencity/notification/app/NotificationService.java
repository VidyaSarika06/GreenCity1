package com.greencity.notification.app;

import java.util.List;
import org.springframework.stereotype.Service;
import com.greencity.notification.domain.Notification;
import com.greencity.notification.infra.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public Notification create(Notification notification) {
        notification.setStatus("UNREAD");
        return repository.save(notification);
    }

    public List<Notification> getByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Notification> getAll() {
        return repository.findAll();
    }

    public Notification markAsRead(Long id) {
        Notification n = repository.findById(id).orElseThrow();
        n.setStatus("READ");
        return repository.save(n);
    }
}