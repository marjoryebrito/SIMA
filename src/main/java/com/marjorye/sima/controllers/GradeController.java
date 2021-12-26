package com.marjorye.sima.controllers;

import com.marjorye.sima.models.Class_;
import com.marjorye.sima.models.Student;
import com.marjorye.sima.repositories.Class_Repository;
import com.marjorye.sima.repositories.GradeRepository;
import com.marjorye.sima.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GradeController {

    private final GradeRepository gradeRepository;

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

        model.addAttribute("classes_", class_repository.findAll());

        return "/grades/add_student_grade";
    }

    @RequestMapping("/grades")
    public String showAddGradesView(){
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


}
