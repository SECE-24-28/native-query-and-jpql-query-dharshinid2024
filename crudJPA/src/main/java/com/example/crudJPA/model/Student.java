package com.example.crudJPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    private int rno;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private String gender;
    private String tech;
    private String email;
    private String password;

}
