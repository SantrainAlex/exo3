package com.example.demoFirst.controller;

import com.example.demoFirst.model.Student;
import com.example.demoFirst.services.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final IStudent IStudent;

    @Autowired
    public StudentController(IStudent IStudent) {
        this.IStudent = IStudent;
    }

    @PostMapping
    public Student create(@RequestBody Student student){

        IStudent.setStudent(student);
        return student;
    }

    @GetMapping
    public List<Student> getAllPerson(){
        return IStudent.allStudent();
    }

    @GetMapping("/{id}")
    public Student getOneStudent(@PathVariable int id){
        return IStudent.getOneStudent(id);
    }

    @GetMapping("/Nom")
    public Student getStudentNom(@RequestBody String nom){
        return IStudent.getOneStudentNom(nom);
    }

    @PutMapping("/{id}")
    public Student udateStudent(@PathVariable int id, @RequestBody Student student){
        return IStudent.updateOneStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        return IStudent.deleteOneStudent(id);
    }
}
