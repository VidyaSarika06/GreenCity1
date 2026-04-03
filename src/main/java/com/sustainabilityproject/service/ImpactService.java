package com.greencity.sustainabilityproject.service;

import com.greencity.sustainabilityproject.entity.Impact;
import com.greencity.sustainabilityproject.repository.ImpactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpactService {

    private final ImpactRepository repository;

    // ✅ Constructor injection (repository initialized correctly)
    public ImpactService(ImpactRepository repository) {
        this.repository = repository;
    }

    // ✅ Returns Impact
    public Impact createImpact(Impact impact) {
        return repository.save(impact);
    }

    // ✅ Returns List<Impact>
    public List<Impact> getAllImpacts() {
        return repository.findAll();
    }
}
