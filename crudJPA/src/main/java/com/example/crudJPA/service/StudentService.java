package com.example.crudJPA.service;

import com.example.crudJPA.dto.StudentDto;
import com.example.crudJPA.model.Student;
import com.example.crudJPA.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository sr;

    public List<Student> getAllStudent() {
        return sr.findAll();

    }

    public String addStudent(Student std) {
        sr.save(std);
        return "Student Added";

    }

    public Student getStudentByRollNo(int roll) {
        return sr.findById(roll).orElse(new Student());
    }

    public void updateStudent(Student std) {
        sr.save(std);
    }

    public void deleteAllStudents() {
        sr.deleteAll();
    }

    public void deleteStudentByRollNo(int roll) {
        sr.deleteById(roll);
    }


    public List<Student> getStudentGenderAndTech(String gender, String tech) {
        return sr.findByGenderAndTech(gender, tech);
    }

    public List<Student> getStudentByTech(String tech) {
        return sr.findByTech(tech);

    }

    public List<Student> getStudentByGenAndTech(String gender, String tech) {
        return sr.findByGenAndTech(gender,tech);
    }

    public List<Student> getStudentByName() {
        return sr.findByStudentName();
    }
    // Dto concept f
    public StudentDto AllStudent(int roll) {
        Student s1 = sr.findById(roll).orElseThrow();
        return convertStuToDto(s1);

    }
    public StudentDto convertStuToDto(Student s1){
        StudentDto std = new StudentDto();
        std.setRno(s1.getRno());
        std.setName(s1.getName());
        std.setGender(s1.getGender());
        std.setTech(s1.getTech());
        std.setEmail(s1.getEmail());
        return std;
    }


    public StudentDto addStudents( StudentDto std) {
        Student student = sr.save(convertDtoToStu(std));
        return convertStuToDto(student);

    }
    public Student convertDtoToStu(StudentDto std){
        Student s2 = new Student();
        s2.setRno(std.getRno());
        s2.setName(std.getName());
        s2.setGender(std.getGender());
        s2.setTech(std.getTech());
        s2.setEmail(std.getEmail());
        return s2;
    }


    public Page<Student> getAllStudent(int page, int size) {
        return sr.findAll(
                PageRequest.of(page,size)

        );
    }
}
