package com.example.school.service;

import com.example.school.dto.StudentDTO;
import com.example.school.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    public Student findById(int theId);

    public void save(StudentDTO studentDTO);

    public void deleteById(int theId);

}
