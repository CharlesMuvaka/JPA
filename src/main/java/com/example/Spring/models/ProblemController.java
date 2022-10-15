package com.example.Spring.models;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller - This annotation makes a Java class able to use

@RestController //Combination between the @controller and @ResponseBody annotation

public class ProblemController {

    @PostMapping(value = "/addProblem")
    public void addProblem(){

    }
}
