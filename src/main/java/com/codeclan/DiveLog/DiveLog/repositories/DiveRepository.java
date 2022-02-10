package com.codeclan.DiveLog.DiveLog.repositories;

import com.codeclan.DiveLog.DiveLog.models.Dive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiveRepository extends JpaRepository<Dive, Long> {
    List<Dive> findByOrderByIdDesc();
}
