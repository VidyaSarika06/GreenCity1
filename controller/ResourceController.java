package com.dev.utilizationmanagement.controller;

import com.dev.utilizationmanagement.entity.Resource;
import com.dev.utilizationmanagement.repository.ResourceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final ResourceRepository repository;

    public ResourceController(ResourceRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Resource create(@RequestBody Resource resource) {
        return repository.save(resource);
    }

    @GetMapping
    public List<Resource> getAll() {
        return repository.findAll();
    }
}