package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    public StudentRepo StudentRepo;

    public Student addStudent(Student student) {
        return StudentRepo.save(student);
    }

    public Student getOneStudent(int studentId) {
        return StudentRepo.findById(studentId).get();
    }

    public List<Student> getAllStudents() {
        return StudentRepo.findAll();
    }

    public Student updateStudent(Student student, int studentId) {
        Student Student2 = StudentRepo.findById(studentId).get();
        Student2.setStudentName(student.getStudentName());
        Student2.setEmail(student.getEmail());
        return StudentRepo.save(Student2);
    }

    public boolean deleteOneStudent(int studentId) {
        if (StudentRepo.findById(studentId).isPresent()) {
            StudentRepo.deleteById(studentId);
            return true;
        }
        return false;
    }

    public Student addNew(Student shirt) {
        return null;
    }

}
