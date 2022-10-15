package com.example.Spring.models;

import org.springframework.data.jpa.repository.JpaRepository;

//JPARepository contains methods of creating, Reading, updating and Deleting resources from our database
public interface ProblemRepository extends JpaRepository<Problem, Integer> {

}
