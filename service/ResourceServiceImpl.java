package com.dev.utilizationmanagement.service;

import com.dev.utilizationmanagement.dto.ResourceDTO;
import com.dev.utilizationmanagement.dto.ResourceUsageDTO;
import com.dev.utilizationmanagement.entity.Resource;
import com.dev.utilizationmanagement.entity.ResourceUsage;
import com.dev.utilizationmanagement.repository.ResourceRepository;
import com.dev.utilizationmanagement.repository.ResourceUsageRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceUsageRepository usageRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository,
                               ResourceUsageRepository usageRepository) {
        this.resourceRepository = resourceRepository;
        this.usageRepository = usageRepository;
    }

    @Override
    public ResourceDTO addResource(ResourceDTO dto) {

        Resource resource = new Resource();
        resource.setType(dto.getType());
        resource.setLocation(dto.getLocation());
        resource.setCapacity(dto.getCapacity());
        resource.setStatus(dto.getStatus());

        resourceRepository.save(resource);
        return dto;
    }

    @Override
    public void addResourceUsage(ResourceUsageDTO dto) {

        Resource resource = resourceRepository.findById(dto.getResourceId())
                .orElseThrow(() -> new RuntimeException("Resource not found"));

        ResourceUsage usage = new ResourceUsage();
        usage.setResource(resource);
        usage.setQuantity(dto.getQuantity());
        usage.setUsageDate(dto.getUsageDate());
        usage.setStatus(dto.getStatus());

        usageRepository.save(usage);
    }
}
