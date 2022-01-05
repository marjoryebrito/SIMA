package com.marjorye.sima.controllers;

import com.marjorye.sima.models.Class_;
import com.marjorye.sima.models.Student;
import com.marjorye.sima.repositories.Class_Repository;
import com.marjorye.sima.repositories.StudentRepository;
import com.marjorye.sima.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    private final Class_Repository class_repository;

    @Autowired
    private Service service;


    public StudentController(StudentRepository studentRepository, Class_Repository class_repository) {
        this.studentRepository = studentRepository;
        this.class_repository = class_repository;
    }



    @RequestMapping("/")
    public String goToIndex(Model model){

        return "/index";
    }


    @RequestMapping("/add-view")
    public String showAddStudentForm(Model model, Student student){

        model.addAttribute("student", student);

        return "/students/add_student";
    }

    @PostMapping("/students-add")
    public String addStudent(@ModelAttribute("student") Student student) {

        service.addStudent(student);

        return "/index";
    }

    @RequestMapping("/students")
    public String getStudents(Model model){

        model.addAttribute("students", studentRepository.findAll());

        return "/students/list";
    }

    @ModelAttribute("classes_list")
        public List<Class_> classes_list(){

        return class_repository.findAll();

    }



    
}
