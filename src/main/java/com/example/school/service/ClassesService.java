package com.example.school.service;

import com.example.school.dto.ClassesDTO;
import com.example.school.dto.StudentDTO;
import com.example.school.entity.Classes;
import com.example.school.entity.Student;

import java.util.List;

public interface ClassesService {

    public List<Classes> findAll();

    public Classes findById(int theId);

    public void save(ClassesDTO classesDTO);

    public void deleteById(int theId);
}
