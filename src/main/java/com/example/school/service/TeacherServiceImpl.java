package com.example.school.service;

import com.example.school.dao.TeacherRepository;
import com.example.school.dao.UserDetailsRepository;
import com.example.school.dto.StudentDTO;
import com.example.school.dto.TeacherDTO;
import com.example.school.entity.Student;
import com.example.school.entity.Teacher;
import com.example.school.entity.UserDetails;
import com.example.school.mapper.StudentMapper;
import com.example.school.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int theId) {
        Optional<Teacher> result = teacherRepository.findById(theId);

        Teacher theTeacher = null;

        if (result.isPresent()) {
            System.out.println(result.get());
            theTeacher = result.get();
            System.out.println(theTeacher);
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find teacher id - " + theId);
        }
        return theTeacher;
    }

    @Override
    public void save(TeacherDTO teacherDTO) {

        Teacher teacher = new Teacher();

        UserDetails user = TeacherMapper.convertTeacherToUser(teacherDTO);
        userDetailsRepository.save(user);
        System.out.println(user);
        teacherDTO.setUserId(user.getUserId());
        teacher = TeacherMapper.convertUserToTeacher(teacherDTO);
        teacherRepository.save(teacher);
        System.out.println(teacher);
    }

    public Teacher updateTeacher(TeacherDTO teacherDTO, int thId) {
        Teacher teacher = TeacherMapper.convertUserToTeacher(teacherDTO);

        teacherDTO.setTeacherId(thId);
        teacherRepository.save(teacher);
        return teacher;
    }

    @Override
    public void deleteById(int theId) {
        teacherRepository.deleteById(theId);
    }
}
