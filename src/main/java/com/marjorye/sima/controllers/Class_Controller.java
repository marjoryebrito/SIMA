package com.marjorye.sima.controllers;

import com.marjorye.sima.models.Class_;
import com.marjorye.sima.models.Student;
import com.marjorye.sima.repositories.Class_Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Class_Controller {

    private final Class_Repository class_repository;

    public Class_Controller(Class_Repository class_repository) {
        this.class_repository = class_repository;
    }


    @RequestMapping("/add-class-view")
    public String showAddClassForm(Model model, Class_ class_){

        model.addAttribute("class_", class_);

        return "/classes_/add_class_";
    }

    @PostMapping("/class_add")
    public String addStudent(@ModelAttribute("class_") Class_ class_) {

        class_repository.save(class_);

        return "/index";
    }

    @RequestMapping("/classes_")
    public String getStudents(Model model){

        model.addAttribute("classes_", class_repository.findAll());

        return "/classes_/class_list";
    }

}
