package com.example.Spring.models;

import com.example.Spring.errorHandling.ApiException;
import com.example.Spring.service.ProblemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String > addProblem(@RequestBody Problem problem1){
        System.out.println(problem1.getDuration());
        if(problem1.getName() == null || problem1.getName().isEmpty() || problem1.getConsequence() == null || problem1.getConsequence().isEmpty()  ||  problem1.getSolution() == null || problem1.getSolution().isEmpty() || problem1.getDuration() == null || problem1.getDuration().isEmpty()){
            ApiException err = new ApiException("Please enter all the required fields", HttpStatus.NO_CONTENT.value());
            return  new ResponseEntity<>( err.getMessage(), HttpStatus.OK);
        }
        service.addProblem(problem1);
        return new ResponseEntity<>( "Problem successfully created", HttpStatus.CREATED);
    }

    //Sending data to the server - There are two ways
    // 1. Using path Variables
    // 2. Using request Params

//    @GetMapping("/getProblem/{id}/{name}")
//    public String getProblem(@PathVariable("id") int id, @PathVariable("name") String problemName){
//        return new String("Your problem id is " + id + "and its name is  " + problemName + "" + databaseName);
//    }

    @GetMapping(path = "/problems")
    public ResponseEntity<List<Problem>> getProblems(){
        return new ResponseEntity<>(service.getProblems(), HttpStatus.OK);
    }

    @GetMapping(path = "/getProblem/{id}")
    public ResponseEntity<Problem> getProblemById(@PathVariable("id") int id){
        Problem newProblem = service.getProblemById(id);
        return new ResponseEntity<>(newProblem, HttpStatus.OK);
    }

    @GetMapping(path = "/getProblemByName/{name}")
    public Problem getProblemByName(@PathVariable("name")String name){
        return service.findProblemByName(name);
    }

    @GetMapping(path = "/getProblemByKeyword/{key}")
    public List<Problem> getProblemByKeyword(@PathVariable("key")String key){
        return service.findProblemContainingKeyword(key);
    }

    @GetMapping(path = "/getProblemByNameAndSolution")
    public Problem getProblemByNameAndSolution(@RequestParam String name, @RequestParam String solution){
        return service.getProblemByNameAndSolution(name, solution);
    }

    @PutMapping(path = "/updateProblem/{id}")
    public Problem updateApiProblem(@PathVariable("id")int id, @RequestBody Problem problem){
        return service.updateProblem(id,problem);
    }

    @DeleteMapping("/deleteProblem/{id}")
    public List<Problem> deleteProblemById(@PathVariable("id")int id){
        return service.deleteProblemById(id);
    }

    @DeleteMapping(path = "/deleteProblems")
    public List<Problem> deleteAllProblems(){
        return service.deleteAll();
    }
}
