package com.marjorye.sima.repositories;

import com.marjorye.sima.models.Grade;
import com.marjorye.sima.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query(value = "SELECT * FROM Students WHERE class_id = id_selected", nativeQuery = true)
    List<Student> findAllStudentsByClass(long id_selected);

}
