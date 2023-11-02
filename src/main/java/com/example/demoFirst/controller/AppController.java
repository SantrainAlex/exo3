package com.example.demoFirst.controller;

import com.example.demoFirst.model.Student;
import com.example.demoFirst.services.IStudent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {

    private final IStudent Istudent;

    public AppController(IStudent Istudent) {
        this.Istudent = Istudent;
    }


    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/form")
    public String formStudent(Model model){
        Student student = new Student();
        model.addAttribute("studentSubmit", student);
        return "student/form";
    }

    @GetMapping("/detail")
    public String detailStudent(){
        return "student/detail";
    }

    @GetMapping("/list")
    public String listStudent(Model model){
        model.addAttribute("lstStudent", Istudent.allStudent());

        return "student/list";
    }

    @PostMapping("/submitForm")
    public String submitFormulaire(@ModelAttribute("studentSubmit") Student student){
        Istudent.setStudent(student);
        return "redirect:/list";
    }

    @GetMapping("{id}")
    public String viewDetail(@PathVariable String id, Model model){
        int currentId = Integer.parseInt(id);
        model.addAttribute("currentStudent", Istudent.getOneStudent(currentId));

        return "student/detail";
    }
    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable String id){
        int currentId = Integer.parseInt(id);
        Istudent.deleteOneStudent(currentId);
        return "redirect:/list";
    }

    @GetMapping("modifier/{id}")
    public String modifStudent(@PathVariable String id, Model model){
        int currentId = Integer.parseInt(id);
        model.addAttribute("studentSubmit", Istudent.getOneStudent(currentId));
        return "student/form";
    }


}
