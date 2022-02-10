package com.codeclan.DiveLog.DiveLog.repositories;

import com.codeclan.DiveLog.DiveLog.models.Regulator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegulatorRepository extends JpaRepository<Regulator, Long> {
}
