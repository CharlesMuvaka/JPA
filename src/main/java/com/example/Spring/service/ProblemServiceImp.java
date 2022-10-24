package com.example.Spring.service;

import com.example.Spring.models.Problem;
import com.example.Spring.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImp implements ProblemService{
    @Autowired
    private ProblemRepository repo;

    @Override
    public Problem addProblem(Problem problem) {
        return repo.save(problem);
    }
}
