package com.marjorye.sima.repositories;

import com.marjorye.sima.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
