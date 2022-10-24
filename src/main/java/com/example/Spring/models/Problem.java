package com.example.Spring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity(name = "user_problem") // creates a relation in the database with the given name
@Table(
        //gives us entire control of our relation such as setting unique keys
        name = "user_problem",
        uniqueConstraints = {
                @UniqueConstraint( name = "user_problem_solution" , columnNames = "problem_solution")
        }
)
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Problem implements Serializable {

    @Id //identifies the id of the class as the primary key

    //defines how the id should be treated by the database
    @SequenceGenerator(
            name = "problem_sequence",
            sequenceName = "problem_sequence",
            allocationSize = 2, //id will be assigned after two steps
            initialValue = 3 //id will begin at this
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "problem_sequence"
    )
    private int id;
    @Column(
            name = "problem_name",
            columnDefinition = "VARCHAR",
            nullable = false
    )
    private String name;
    @Column(
            name = "problem_consequence",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String consequence;

    @Column(
            name = "problem_solution",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String solution;
    @Column(
            name = "problem_duration",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String duration;

    public Problem() {
    }

    public Problem( String name, String consequence, String solution, String duration) {
        this.name = name;
        this.consequence = consequence;
        this.solution = solution;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return Objects.equals(name, problem.name) && Objects.equals(consequence, problem.consequence) && Objects.equals(solution, problem.solution) && Objects.equals(duration, problem.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, consequence, solution, duration);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
