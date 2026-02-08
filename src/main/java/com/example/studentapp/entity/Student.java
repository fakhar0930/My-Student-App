package com.example.studentapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name Cannot be Null")
    @NotBlank(message = "Name Cannot be Blank")
    @NotEmpty(message = "Name Cannot be Empty")
    private String name;

    @Email
    @NotEmpty
    @NotBlank
    @NotNull
    private String email;

    @Positive
    @Min(value = 18,message = "Date Must be Atleast 18 Years Old")
    @Max(100)
    private int age;
}
