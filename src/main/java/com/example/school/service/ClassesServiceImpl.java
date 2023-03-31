package com.example.school.service;

import com.example.school.dao.ClassesRepository;
import com.example.school.dao.TeacherRepository;
import com.example.school.dto.ClassesDTO;
import com.example.school.dto.StudentDTO;
import com.example.school.entity.Classes;
import com.example.school.entity.Student;
import com.example.school.entity.Teacher;
import com.example.school.mapper.ClassesMapper;
import com.example.school.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassesServiceImpl implements ClassesService{

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Classes findById(int theId) {
        Optional<Classes> result = classesRepository.findById(theId);

        Classes theClasses = null;

        if (result.isPresent()) {
            System.out.println(result.get());
            theClasses = result.get();
            System.out.println(theClasses);
        } else {
            throw new RuntimeException("Did not find class id - " + theId);
        }
        return theClasses;
    }

    @Override
    public void save(ClassesDTO classesDTO) {
        Classes classes = new Classes();

        Teacher teacher = ClassesMapper.convertClassToTeacher(classesDTO);
        System.out.println(teacher);
        teacherRepository.save(teacher);
        System.out.println(teacher);
        classesDTO.setTeacherId(teacher.getTeacherId());
        classes = ClassesMapper.convertTeacherToClass(classesDTO);
        classesRepository.save(classes);
        System.out.println(classes);
    }

    public Classes updateClasses(ClassesDTO classesDTO, int thId) {
        Classes classes = ClassesMapper.convertTeacherToClass(classesDTO);

        classesDTO.setClassId(thId);
        classesRepository.save(classes);
        return classes;
    }

    @Override
    public void deleteById(int theId) {
        classesRepository.deleteById(theId);
    }
}
