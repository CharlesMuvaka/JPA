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
        return repo.getReferenceById(id);
    }

    @Override
    public Problem updateProblem(int id, Problem problem) {
        problem.setId(id);
        return repo.save(problem);
    }

    @Override
    public List<Problem> deleteProblemById(int id) {
        repo.deleteById(id);
        return repo.findAll();
    }

    @Override
    public List<Problem> deleteAll() {
        repo.deleteAll();
        return repo.findAll();
    }

    @Override
    public Problem findProblemByName(String name) {
        return repo.findByName(name);
    }


}
