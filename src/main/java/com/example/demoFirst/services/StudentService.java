package com.example.demoFirst.services;

import com.example.demoFirst.model.Student;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class StudentService implements IStudent {
    List<Student> lstStudents = new ArrayList<Student>();
    int currentId = 1;

    public String getAllInfo(Student students) {
        return students.getId() + " "+students.getNom()+ " "+ students.getPrenom();
    }
    public void setStudent(Student student) {
        student.setId(currentId);
        ++currentId;
        lstStudents.add(student);
    }

    @Override
    public List<Student> allStudent() {
        return lstStudents;
    }

    @Override
    public Student getOneStudent(int id) {
        for (Student e: lstStudents){
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }

    @Override
    public Student getOneStudentNom(String nom) {
        for (Student e: lstStudents){
            if (Objects.equals(e.getNom(), nom)){
                return e;
            }
        }
        return null;
    }

    @Override
    public Student updateOneStudent(int id, Student student) {
        for (Student e: lstStudents){
            if (e.getId() == id){
                e.setNom(student.getNom());
                e.setAge(student.getAge());
                e.setPrenom(student.getPrenom());
                return e;
            }
        }
        return null;
    }

    @Override
    public String deleteOneStudent(int id) {
        lstStudents.removeIf(student -> student.getId() == id);
        return "student supprimer";
    }
}
