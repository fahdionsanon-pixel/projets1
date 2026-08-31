package com.Spring.Cicada.service;

import com.Spring.Cicada.model.ActifIT;
import com.Spring.Cicada.repository.ActifITRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActifITService {
    @Autowired
    private ActifITRepository actifITRepository;

    public ActifIT createActifIT(ActifIT actifIT) {
        return actifITRepository.save(actifIT);
    }

    public void deleteActifIT(Long id) {
        actifITRepository.deleteById(id);
    }
    
    public List<ActifIT> getAllActifITs() {
        return actifITRepository.findAll();
    }
}
