package com.codeclan.DiveLog.DiveLog.repositories;

import com.codeclan.DiveLog.DiveLog.models.Cylinder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CylinderRepository extends JpaRepository<Cylinder, Long> {
}
