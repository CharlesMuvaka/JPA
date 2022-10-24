package com.example.Spring.service;

import com.example.Spring.models.Problem;
import com.example.Spring.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImp implements ProblemService{
    @Autowired
    private ProblemRepository repo;

    @Override
    public Problem addProblem(Problem problem) {
        return repo.save(problem);
    }

    @Override
    public List<Problem> getProblems() {
        return repo.findAll();
    }

    @Override
    public Problem getProblemById(int id) {
        Problem newProblem = repo.getReferenceById(id);
        return newProblem;
    }

    @Override
    public Problem updateProblem(int id, Problem problem) {
        problem.setId(id);

        return repo.save(problem);
    }


}
