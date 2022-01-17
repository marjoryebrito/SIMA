package com.marjorye.sima.repositories;

import com.marjorye.sima.models.Grade;
import com.marjorye.sima.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {


    @Query(value = "SELECT * FROM Grade grade WHERE grade.student_id = ?1", nativeQuery = true)
    List<Grade> findGradesByStudentId(long student_id);

    @Query(value = "SELECT * FROM Grade grade WHERE grade.student_id = ?1 and class_id = ?2 and subject_id = ?3", nativeQuery = true)
    Grade findGradesByIds(long student_id, long class_id, long subject_id);


}
