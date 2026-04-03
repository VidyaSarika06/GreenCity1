package com.greencity.sustainabilityproject.controller;

import com.greencity.sustainabilityproject.entity.Project;
import com.greencity.sustainabilityproject.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    // ✅ Constructor injection (service initialized)
    public ProjectController(ProjectService service) {
        this.service = service;
    }

    // ✅ POST – create project
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return service.createProject(project);
    }

    // ✅ GET – fetch all projects
    @GetMapping
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }
}