package com.greencity.sustainabilityproject.controller;

import com.greencity.sustainabilityproject.entity.Milestone;
import com.greencity.sustainabilityproject.service.MilestoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/milestones")
public class MilestoneController {

    private final MilestoneService service;

    // ✅ Constructor injection (service initialized)
    public MilestoneController(MilestoneService service) {
        this.service = service;
    }

    // ✅ POST – create milestone
    @PostMapping
    public Milestone createMilestone(@RequestBody Milestone milestone) {
        return service.createMilestone(milestone);
    }

    // ✅ GET – fetch all milestones
    @GetMapping
    public List<Milestone> getAllMilestones() {
        return service.getAllMilestones();
    }
}