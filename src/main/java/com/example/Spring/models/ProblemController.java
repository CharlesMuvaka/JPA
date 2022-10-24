package com.example.Spring.models;

import com.example.Spring.service.ProblemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller - This annotation makes a Java class able to handle http requests

@RestController //Combination between the @controller and @ResponseBody annotation
//@RequestMapping(path = "/api/v1")
public class ProblemController {

    @Value("${spring.datasource.password}")
    private String databaseName;

    @Autowired
    private ProblemServiceImp service;


//    @RequestMapping(value = "/addProblem", method = RequestMethod.POST) //generates an API endpoint
//    @ResponseBody  //enables getting data from the server
    @PostMapping(value = "/addProblem")
    public Problem addProblem(@RequestBody Problem problem1){
        System.out.println(problem1.getDuration());
        service.addProblem(problem1);
        return problem1;
    }

    //Sending data to the server - There are two ways
    // 1. Using path Variables
    // 2. Using request Params

    @GetMapping("/getProblem/{id}/{name}")
    public String getProblem(@PathVariable("id") int id, @PathVariable("name") String problemName){
        return new String("Your problem id is " + id + "and its name is  " + problemName + "" + databaseName);
    }

    @GetMapping(path = "/problems")
    public List<Problem> getProblems(){
        return service.getProblems();
    }
}
