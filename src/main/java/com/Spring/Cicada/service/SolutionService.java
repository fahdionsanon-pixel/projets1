package com.Spring.Cicada.service;

import com.Spring.Cicada.model.Solution;
import com.Spring.Cicada.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SolutionService {

    @Autowired
    private SolutionRepository solutionRepository;

    public List<Solution> getAllSolutions() {
        return solutionRepository.findAll();
    }

    public Solution createSolution(Solution solution) {
        return solutionRepository.save(solution);
    }
}