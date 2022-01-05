package com.marjorye.sima.controllers;

import com.marjorye.sima.models.Class_;
import com.marjorye.sima.models.Grade;
import com.marjorye.sima.models.Student;
import com.marjorye.sima.models.Subject_;
import com.marjorye.sima.repositories.Class_Repository;
import com.marjorye.sima.repositories.GradeRepository;
import com.marjorye.sima.repositories.StudentRepository;
import com.marjorye.sima.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class GradeController {

    private final GradeRepository gradeRepository;

    @Autowired
    private Service service;

    @Autowired
    private final Class_Repository class_repository;

    @Autowired
    private final StudentRepository studentRepository;

    public GradeController(GradeRepository gradeRepository, Class_Repository class_repository, StudentRepository studentRepository) {
        this.gradeRepository = gradeRepository;
        this.class_repository = class_repository;
        this.studentRepository = studentRepository;
    }


    @RequestMapping("/add-grade-view")
    public String showChoseClassview(Model model){

        Student student = new Student();

        model.addAttribute("student", student);
        model.addAttribute("classes_", class_repository.findAll());


        return "/grades/add_student_grade";
    }



    @GetMapping("/grades")
    public String showAddGradesView(@ModelAttribute("student") Student student, Model model){


        final Optional<Student> dto = studentRepository.findById(student.getId());
        model.addAttribute("student", dto.get().getName().toString());

        List<Grade> list = service.findGradesByIdStudent(dto.get());

        model.addAttribute("grades_list", list);

        return "/grades/grade_view";
    }

    @PostMapping("/grade-add")
    public String addGrade(){

        return "/index";
    }

   @ModelAttribute("students_list")
    public List<Student> students_list(){

        return studentRepository.findAll();

    }

    @ModelAttribute("subjects_list")
    public List<Subject_> subjects_list(){
       // Subject_ subjects = new Subject_();

        return service.subjectList();
    }



}
