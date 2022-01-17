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

    @Autowired
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
        List<Grade> list = service.findGradesByIdStudent(dto.get());
        Grade grades = new Grade();


        grades.setStudent_id(dto.get().getId());
        grades.setClass_id(dto.get().getClass_id());


        model.addAttribute("student", dto.get());
        model.addAttribute("grades_list", list);
        model.addAttribute("new_grades", grades);

        return "/grades/grade_view";
    }


    @GetMapping("/grade-add")
    public String addGrade(@ModelAttribute("new_grades") Grade grades, Model model){
        Student st = new Student();
        st.setId(grades.getStudent_id());

        List<Grade> list = service.findGradesByIdStudent(st);

        model.addAttribute("subject", grades.getSubject_id());
        model.addAttribute("new_grades", grades);
        model.addAttribute("grades_list", list);

        //System.out.println(grades);

        //service.updateGrades(grades.getStudent_id(), grades.getClass_id(), grades.getSubject_id(), grades);

        return "/grades/grades_form_view";
    }



   @ModelAttribute("students_list")
    public List<Student> students_list(){

        return studentRepository.findAll();

    }

    @ModelAttribute("subjects_list")
    public List<Subject_> subjects_list(){
        return service.subjectList();
    }



}
