package com.example.studentapp.service;

import com.example.studentapp.entity.Student;
import com.example.studentapp.exception.UserAlreadyExistsException;
import com.example.studentapp.exception.UserNotFoundException;
import com.example.studentapp.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repo;

    public Student save(Student student) {
        Optional<Student> student1 = repo.findByName(student.getName());
        if (student1.isPresent()){
            throw new UserAlreadyExistsException("User with Name " + student.getName() + " Already Exist!");
        }

        return repo.save(student); }
    public List<Student> getAll() { return repo.findAll(); }
    public Student get(Long id) {
        return repo.findById(id).orElseThrow(()->new UserNotFoundException("User With Id " + id + " Not Found in DB :( "));
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
