package com.greencity.sustainabilityproject.service;

import com.greencity.sustainabilityproject.entity.Milestone;
import com.greencity.sustainabilityproject.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneService {

    private final MilestoneRepository repository;

    // ✅ Constructor injection (repository initialized)
    public MilestoneService(MilestoneRepository repository) {
        this.repository = repository;
    }

    // ✅ Method correctly RETURNS Milestone
    public Milestone createMilestone(Milestone milestone) {
        return repository.save(milestone);
    }

    // ✅ Method correctly RETURNS List<Milestone>
    public List<Milestone> getAllMilestones() {
        return repository.findAll();
    }
}