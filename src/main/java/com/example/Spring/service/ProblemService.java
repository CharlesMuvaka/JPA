package com.example.Spring.service;

import com.example.Spring.models.Problem;

import java.util.List;

public interface ProblemService {

     Problem addProblem(Problem problem);
     List<Problem> getProblems();
     Problem getProblemById(int id);
}
