package com.example.Spring.repository;

import com.example.Spring.models.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JPARepository contains methods of creating, Reading, updating and Deleting resources from our database
@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {
    //add a method to query the database based on the problems name
    //SELECT * FROM user_problem WHERE name = :name;
    Problem findByName(String name);

    //SELECT * FROM user_problem LIKE %per%
    List<Problem> findByNameContains(String Keyword);

    //SELECT * FROM user_problem WHERE name = :name AND solution = :name
    Problem findByNameAndSolution(String name, String solution);


}
