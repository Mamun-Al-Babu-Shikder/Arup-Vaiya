package com.example.arup.dao;

import com.example.arup.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s from Student s where s.name=:n")
    List<Student> getStudent(@Param("n") String name);

    @Transactional
    @Modifying
    @Query("update Student s set s.name=:n where s.id=:id")
    int updateStudent(@Param("n") String name, @Param("id") int id);
}
