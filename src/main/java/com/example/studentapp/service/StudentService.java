package com.example.studentapp.service;

import com.example.studentapp.entity.Student;
import com.example.studentapp.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repo;

    public Student save(Student student) { return repo.save(student); }
    public List<Student> getAll() { return repo.findAll(); }
    public Student get(Long id) {
        return repo.findById(id).orElse(null);
    }
    public Student update(Long id, Student s) {
        Student existing = get(id);
        existing.setName(s.getName());
        existing.setEmail(s.getEmail());
        existing.setAge(s.getAge());
        return repo.save(existing);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
