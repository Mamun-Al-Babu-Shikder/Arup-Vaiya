package com.example.arup.service;

import com.example.arup.dao.StudentRepository;
import com.example.arup.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
       return studentRepository.save(student);
    }

}
