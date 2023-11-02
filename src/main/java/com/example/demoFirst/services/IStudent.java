package com.example.demoFirst.services;

import com.example.demoFirst.model.Student;

import java.util.List;

public interface IStudent {
    void setStudent(Student student);

    List<Student> allStudent();

    Student getOneStudent(int id);
    Student getOneStudentNom(String nom);

    Student updateOneStudent(int id, Student student);

    String deleteOneStudent(int id);
}
