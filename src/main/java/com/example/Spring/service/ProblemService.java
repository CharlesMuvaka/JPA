package com.example.Spring.service;

import com.example.Spring.models.Problem;

import java.util.List;

public interface ProblemService {

     Problem addProblem(Problem problem);
     List<Problem> getProblems();
     Problem getProblemById(int id);
     Problem updateProblem(int id, Problem problem);
     List<Problem> deleteProblemById(int id);
     List<Problem> deleteAll();

     Problem findProblemByName(String name);
     List<Problem> findProblemContainingKeyword(String keyword);
     Problem getProblemByNameAndSolution(String name, String solution);
}
