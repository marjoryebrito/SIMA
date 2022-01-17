package com.marjorye.sima.service;

import com.marjorye.sima.models.Grade;
import com.marjorye.sima.models.Student;
import com.marjorye.sima.models.Subject_;
import com.marjorye.sima.repositories.GradeRepository;
import com.marjorye.sima.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@org.springframework.stereotype.Service
public class Service {

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    StudentRepository studentRepository;

    ///////Class

    ///////Grades

    public void addGrades(Grade grades){
        Grade g = new Grade();

        System.out.println("New Grades!!!");
        System.out.println("Subject: "+grades.getSubject_id());
        System.out.println("1: "+grades.getPeriod1());
        System.out.println("2: "+grades.getPeriod2());
        System.out.println("3: "+grades.getPeriod3());


        g.setStudent_id(grades.getStudent_id());
        g.setClass_id(grades.getClass_id());
        g.setSubject_id(grades.getSubject_id());
        g.setPeriod1(grades.getPeriod1());
        g.setPeriod2(grades.getPeriod2());
        g.setPeriod3(grades.getPeriod3());
        g.setRecovery(grades.getRecovery());

        gradeRepository.save(g);
    }

    public void updateGrades(long StudentId, long classId, long subjectId, Grade newGrades){

        Grade gradeEntity = gradeRepository.findGradesByIds(StudentId, classId, subjectId);
        Grade grade =  new Grade();


        if(gradeEntity != null){
            grade = gradeEntity;
        }

        grade.setPeriod1(newGrades.getPeriod1());
        grade.setPeriod2(newGrades.getPeriod2());
        grade.setPeriod3(newGrades.getPeriod3());
        grade.setRecovery(newGrades.getRecovery());

         gradeRepository.save(grade);

    }

    public void initiateGrades(Student student){
        List<Subject_> list= subjectList();
        Grade g = new Grade();

        for(int i = 0; i < list.size(); i++){
            g.setSubject_id(list.get(i).getId());
            g.setStudent_id(student.getId());
            g.setClass_id(student.getClass_id());
            g.setPeriod1(0.0);
            g.setPeriod2(0.0);
            g.setPeriod3(0.0);
            g.setRecovery(0.0);
            gradeRepository.save(g);
        }
    }

    public List<Grade> findGradesByIdStudent(Student student){

        List<Grade> list = new ArrayList<>();
        list = gradeRepository.findGradesByStudentId(student.getId());

       /* for(int i = 0; i<list.size(); i++){
            System.out.println("Subject: " + list.get(i).getSubject_id());
            System.out.println("G1: " + list.get(i).getPeriod1());
            System.out.println("G2: " + list.get(i).getPeriod2());
            System.out.println("G3: " + list.get(i).getPeriod3());
            System.out.println("G4: " + list.get(i).getRecovery());

        }*/

        return list;
    }

    ///////Students

    public void addStudent(Student student){
        Student s = new Student();
        s = studentRepository.save(student);
        initiateGrades(s);
    }


    ///////Subjects

    public List<Subject_> subjectList(){
        List<Subject_> subject_list = new ArrayList<>();
        Subject_ s1 = new Subject_(1, "Language");
        Subject_ s2 = new Subject_(2, "Math");
        Subject_ s3 = new Subject_(3, "Science");
        Subject_ s4 = new Subject_(4, "Geography");
        Subject_ s5 = new Subject_(5, "History");
        Subject_ s6 = new Subject_(6, "Arts");
        Subject_ s7 = new Subject_(7, "PE");
        Subject_ s8 = new Subject_(8, "Foreign language");

        subject_list.add(s1);
        subject_list.add(s2);
        subject_list.add(s3);
        subject_list.add(s4);
        subject_list.add(s5);
        subject_list.add(s6);
        subject_list.add(s7);
        subject_list.add(s8);

        return  subject_list;
    }

}
