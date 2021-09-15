package com.marjorye.sima.controllers;

import com.marjorye.sima.models.Student;
import com.marjorye.sima.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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

        studentRepository.save(student);

        return "/index";
    }

    @RequestMapping("/students")
    public String getStudents(Model model){

        model.addAttribute("students", studentRepository.findAll());

        return "/students/list";
    }

}
