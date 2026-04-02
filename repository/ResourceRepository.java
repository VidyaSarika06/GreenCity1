package com.dev.utilizationmanagement.repository;

import com.dev.utilizationmanagement.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
