package com.codeclan.DiveLog.DiveLog.repositories;

import com.codeclan.DiveLog.DiveLog.models.SamplePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SamplePointRepository extends JpaRepository<SamplePoint, Long> {
    List<SamplePoint> findByDiveId(Long id);
}
