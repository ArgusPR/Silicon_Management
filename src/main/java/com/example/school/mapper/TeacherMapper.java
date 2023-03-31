package com.example.school.mapper;

import com.example.school.dto.TeacherDTO;
import com.example.school.entity.Teacher;
import com.example.school.entity.UserDetails;

public class TeacherMapper {

    public static UserDetails convertTeacherToUser(TeacherDTO teacherDTO) {
        UserDetails user = new UserDetails();
        user.setUserId(teacherDTO.getUserId());
        user.setFullName(teacherDTO.getFullName());
        user.setCurrentAddress(teacherDTO.getCurrentAddress());
        user.setDob(teacherDTO.getDob());
        user.setGender(teacherDTO.getGender());
        user.setRole(teacherDTO.getRole());
        user.setPermanentAddress(teacherDTO.getPermanentAddress());
        user.setPhone(teacherDTO.getPhone());

        return user;
    }

    public static Teacher convertUserToTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherDTO.getTeacherId());
        teacher.setQualification(teacherDTO.getQualification());
        teacher.setUserId(teacherDTO.getUserId());
        teacher.setSubTaught(teacherDTO.getSubTaught());
        teacher.setClassTaught(teacherDTO.getClassTaught());

        return teacher;
    }
}
