package com.example.crudJPA.repository;

import com.example.crudJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    // Abstract method sometimes its not working so use native query or jpql query

    List<Student> findByGenderAndTech(String gender, String tech);

    List<Student> findByTech(String tech);

    @Query(nativeQuery = true,
    value = "SELECT * FROM Student where gender=:gender And tech=:tech")

    List<Student> findByGenAndTech(
            @Param("gender") String gender,
            @Param("tech") String tech
    );

    @Query("SELECT s FROM Student s WHERE s.name = 'Dharshini'")
    List<Student> findByStudentName();

}

