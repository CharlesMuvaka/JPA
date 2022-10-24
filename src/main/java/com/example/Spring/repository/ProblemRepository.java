package com.example.Spring.repository;

import com.example.Spring.models.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPARepository contains methods of creating, Reading, updating and Deleting resources from our database
@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {


}
