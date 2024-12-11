package com.pranay.JpaExamples.repository;

import com.pranay.JpaExamples.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Assignment
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
