package com.example.crudJPA.controller;

import com.example.crudJPA.dto.StudentDto;
import com.example.crudJPA.model.Student;
import com.example.crudJPA.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    StudentService s;

    @GetMapping("students")
    public List<Student> getAllStudent() {
       return s.getAllStudent();
    }

//    @PostMapping("students")
//    public String addStudent( @Valid @RequestBody Student std) {
//        return s.addStudent(std);
//    }

//    @GetMapping("students/{rno}")
//    public Student getStudentByRollNo(@PathVariable("rno") int roll) {
//        return s.getStudentByRollNo(roll);
//    }

    @PutMapping("students")
    public String updateStudent(@RequestBody Student std) {
        s.updateStudent(std);
        return "updated";
    }

    @DeleteMapping("students")
    public String deleteAllStudents() {
        s.deleteAllStudents();
        return "Deleted Successfully";
    }

    @DeleteMapping("students/{rno}")
    public String deleteStudentByRollNo(@PathVariable("rno") int roll) {
        s.deleteStudentByRollNo(roll);
        return "Deleted";
    }

    @GetMapping("/students/custom")
    public List<Student> getStudentByGenderAndTech(
            @Param("gender") String gender,
           @Param("tech") String tech){

       return s.getStudentGenderAndTech(gender, tech);
    }
    @GetMapping("students/technology/{tech}")
    public List<Student> getStudentByTech(@PathVariable("tech") String tech){
        return s.getStudentByTech(tech);
    }
    //native query
    @PostMapping("students/filter")
    public List<Student> getStudentByGenAndTech(
            @Param("gender") String gender,
            @Param("tech") String tech
    ){
        return s.getStudentByGenAndTech(gender,tech);
    }
    //jpql query
    @GetMapping("students/name")
    public List<Student> getStudentByName(){
        return s.getStudentByName();
    }
    @GetMapping("students/{rno}")
    public StudentDto getAllStudent(@PathVariable("rno") int roll){
        return s.AllStudent(roll);
    }
    @PostMapping("students")
    public StudentDto addStudent(@Valid @RequestBody StudentDto std){
        return s.addStudents(std);
    }
    @GetMapping("student")
    public Page<Student> getAllStudent(@RequestParam("page") int page,
                                       @RequestParam("size") int size){
        return s.getAllStudent(page,size);
    }

}

