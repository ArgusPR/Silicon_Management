package com.example.school.service;

import com.example.school.dto.TeacherDTO;
import com.example.school.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> findAll();

    public Teacher findById(int theId);

    public void save(TeacherDTO teacherDTO);

    public void deleteById(int theId);
}
