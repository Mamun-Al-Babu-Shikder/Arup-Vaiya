package com.example.arup.controller;

import com.example.arup.dao.StudentRepository;
import com.example.arup.entity.Student;
import com.example.arup.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @Autowired
    StudentRepository repository;


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping({"/home"})
    public String homePage(Model model) {
        System.out.println("# inside controller");
        return "index2";
    }

    @ResponseBody
    @GetMapping("/students")
    public List<Student> fetchAllStudent() {
       return studentService.getAllStudent();
    }

    @ResponseBody
    @GetMapping("/save")
    public Student save(@RequestParam("name") String name, @RequestParam("cgpa") float cgpa) {
        Student s = new Student();
        s.setName(name);
        s.setCgpa(cgpa);

        return studentService.save(s);
    }

    @ResponseBody
    @GetMapping("/student")
    public List<Student> getStudentByName(@RequestParam String name) {
        return repository.getStudent(name);
    }

    @ResponseBody
    @GetMapping("/update")
    public int getStudentByName(@RequestParam String name, @RequestParam int id) {
        return repository.updateStudent(name, id);
    }



}
