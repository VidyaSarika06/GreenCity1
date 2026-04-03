package com.greencity.sustainabilityproject.service;

import com.greencity.sustainabilityproject.entity.Project;
import com.greencity.sustainabilityproject.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    // ✅ Constructor injection (repository initialized)
    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    // ✅ Method returns Project
    public Project createProject(Project project) {
        return repository.save(project);
    }

    // ✅ Method returns List<Project>
    public List<Project> getAllProjects() {
        return repository.findAll();
    }
}