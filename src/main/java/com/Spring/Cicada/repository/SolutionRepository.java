package com.Spring.Cicada.repository;

import com.Spring.Cicada.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
}