package com.dev.utilizationmanagement.service;

import com.dev.utilizationmanagement.dto.ResourceDTO;
import com.dev.utilizationmanagement.dto.ResourceUsageDTO;

public interface ResourceService {

    ResourceDTO addResource(ResourceDTO resourceDTO);

    void addResourceUsage(ResourceUsageDTO usageDTO);
}
