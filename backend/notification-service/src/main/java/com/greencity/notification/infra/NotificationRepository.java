package com.greencity.notification.infra;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.greencity.notification.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUserId(Long userId);

    List<Notification> findByStatus(String status);

    List<Notification> findByProjectId(Long projectId);

    List<Notification> findByResourceId(Long resourceId);
}
