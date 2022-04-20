package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @version V1.0
 * @Description: 创建Repository 继承 JpaRepository
 * @author: rudy
 * @date: 2022/4/16 20:06
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    // SELECT * FROM entity where email = ?
    @Query(value = "SELECT s from Student as s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
