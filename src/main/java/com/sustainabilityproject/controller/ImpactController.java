package com.greencity.sustainabilityproject.controller;

import com.greencity.sustainabilityproject.entity.Impact;
import com.greencity.sustainabilityproject.service.ImpactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/impacts")
public class ImpactController {

    private final ImpactService service;

    // ✅ Constructor injection (service initialized)
    public ImpactController(ImpactService service) {
        this.service = service;
    }

    // ✅ POST – create impact
    @PostMapping
    public Impact createImpact(@RequestBody Impact impact) {
        return service.createImpact(impact);
    }

    // ✅ GET – fetch all impacts
    @GetMapping
    public List<Impact> getAllImpacts() {
        return service.getAllImpacts();
    }
}