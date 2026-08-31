package com.Spring.Cicada.service;

import com.Spring.Cicada.model.Probleme;
import com.Spring.Cicada.repository.ProblemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProblemeService {

    @Autowired
    private ProblemeRepository problemeRepository;

    public List<Probleme> getAllProblemes() {
        return problemeRepository.findAll();
    }

    public Probleme createProbleme(Probleme probleme) {
        return problemeRepository.save(probleme);
    }
}