package com.example.school.rest;

import com.example.school.dto.StudentDTO;
import com.example.school.dto.TeacherDTO;
import com.example.school.entity.Student;
import com.example.school.entity.Teacher;
import com.example.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api")
public class TeacherRestController {
    private TeacherService teacherService;

    @Autowired
    public TeacherRestController(TeacherService theTeacherService) {
        teacherService = theTeacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/teachers/{teacherId}")
    public Teacher getTeacher(@PathVariable int teacherId) {
        Teacher theTeacher =teacherService.findById(teacherId);
        System.out.println(theTeacher);
        if(theTeacher == null) {
            throw new RuntimeException("Teacher id not found : "+teacherId);
        }
        return theTeacher;
    }

    @PostMapping("/teachers")
    public TeacherDTO addTeacher(@RequestBody TeacherDTO teacherDTO) {

        teacherService.save(teacherDTO);
        return teacherDTO;

    }

    @PutMapping("/teachers/{teacherId}")
    public TeacherDTO updateTeacher(@PathVariable int teacherId, @RequestBody TeacherDTO teacherDTO) {
        teacherDTO.setTeacherId(teacherId);
        System.out.println(teacherDTO);
        teacherService.save(teacherDTO);
        return teacherDTO;
    }

    @DeleteMapping("/teachers/{teacherId}")
    public Teacher deleteTeacher(@PathVariable int teacherId) {
        Teacher tempTeacher = teacherService.findById(teacherId);

        if(tempTeacher == null) {
            throw new RuntimeException("Teacher id not found.." + teacherId);
        }
        Teacher theTeacher =teacherService.findById(teacherId);
        teacherService.deleteById(teacherId);

        return theTeacher;
    }
}
