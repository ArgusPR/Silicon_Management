package com.example.school.service;

import com.example.school.dao.StudentRepository;
import com.example.school.dao.UserDetailsRepository;
import com.example.school.dto.StudentDTO;
import com.example.school.entity.Student;
import com.example.school.entity.UserDetails;
import com.example.school.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    //    public StudentServiceImpl(StudentRepository theStudentRepository) {
//        studentRepository = theStudentRepository;
//    }
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;

        if (result.isPresent()) {
            System.out.println(result.get());
            theStudent = result.get();
            System.out.println(theStudent);
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find student id - " + theId);
        }
        return theStudent;
    }

    @Override
    public void save(StudentDTO studentDTO) {
        Student student = new Student();
//        if(Objects.nonNull(studentDTO.getStudId()) && studentDTO.getStudId() != 0){
//            student = studentRepository.findById(studentDTO.getStudId()).get();
//            studentDTO.setUserId(student.getUserId());
//        }


//        studentRepository.save(theStudent);
        UserDetails user = StudentMapper.convertStudentToUser(studentDTO);
        userDetailsRepository.save(user);
        System.out.println(user);
        studentDTO.setUserId(user.getUserId());
        student = StudentMapper.convertUserToStudent(studentDTO);
        studentRepository.save(student);

        System.out.println(student);
    }

    public Student updateStudent(StudentDTO studentDTO, int thId) {
        Student student = StudentMapper.convertUserToStudent(studentDTO);

        studentDTO.setStudId(thId);
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }
}
