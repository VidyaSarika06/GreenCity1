package com.greencity.identity.app;

import java.time.Instant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greencity.identity.domain.AuditLog;
import com.greencity.identity.infra.AuditLogRepository;

@Service
public class AuditService {

    @Autowired
    private AuditLogRepository repo;

    public void audit(String action, String resource, Long userId) {
        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setResource(resource);
        log.setUserId(userId);
        log.setTimestamp(Instant.now());
        repo.save(log);
    }
}