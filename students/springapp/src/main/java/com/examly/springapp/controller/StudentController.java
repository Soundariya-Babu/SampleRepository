package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Student;
import com.examly.springapp.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    public StudentService apiService;

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return apiService.getAllStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student getOneStudent(@PathVariable int studentId) {
        return apiService.getOneStudent(studentId);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addNewShirt(@RequestBody Student student) {
        Student newStudent = apiService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @PutMapping("/student/{studentId}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int studentId) {
        return apiService.updateStudent(student, studentId);
    }

    @DeleteMapping("/student/{studentId}")
    public boolean deleteOneStudent(@PathVariable int studentId) {
        return apiService.deleteOneStudent(studentId);
    }

}
