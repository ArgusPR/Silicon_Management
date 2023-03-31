package com.example.school.mapper;

import com.example.school.dto.StudentDTO;
import com.example.school.entity.Student;
import com.example.school.entity.UserDetails;

public class StudentMapper {

    public static UserDetails convertStudentToUser(StudentDTO studentDTO) {
        UserDetails user = new UserDetails();
        user.setUserId(studentDTO.getUserId());
        user.setFullName(studentDTO.getFullName());
        user.setCurrentAddress(studentDTO.getCurrentAddress());
        user.setDob(studentDTO.getDob());
        user.setGender(studentDTO.getGender());
        user.setRole(studentDTO.getRole());
        user.setPermanentAddress(studentDTO.getPermanentAddress());
        user.setPhone(studentDTO.getPhone());

        return user;
    }

    public static Student convertUserToStudent(StudentDTO studentDTO) {
        Student student = new Student();
//        student.setHobbies(studentDTO.getHobbies());
        student.setStudId(studentDTO.getStudId());
        student.setHobbies(studentDTO.getHobbies());
        student.setStandard(studentDTO.getStandard());
        student.setUserId(studentDTO.getUserId());

        return student;
    }
}
