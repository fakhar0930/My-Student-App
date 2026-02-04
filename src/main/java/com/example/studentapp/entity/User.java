package com.example.studentapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuYXZpbiIsImV4cCI6MTc2NTM2MTM0Mn0.xrMqVpa0BFWhTEQsYoCbR-mDaJK5G-pu8iJElUaZ0HQ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
}
