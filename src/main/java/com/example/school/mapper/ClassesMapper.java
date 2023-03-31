package com.example.school.mapper;

import com.example.school.dto.ClassesDTO;
import com.example.school.entity.Classes;
import com.example.school.entity.Teacher;

public class ClassesMapper {

    public static Teacher convertClassToTeacher(ClassesDTO classesDTO) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(classesDTO.getTeacherId());
        teacher.setSubTaught(classesDTO.getSubTaught());
        teacher.setClassTaught(classesDTO.getClassTaught());
        teacher.setQualification(classesDTO.getQualification());
        return teacher;
    }

    public static Classes convertTeacherToClass(ClassesDTO classesDTO) {
        Classes classes = new Classes();

        classes.setClassId(classesDTO.getClassId());
        classes.setClassName(classesDTO.getClassName());
        classes.setTeacherId(classesDTO.getTeacherId());
        return classes;
    }
}
