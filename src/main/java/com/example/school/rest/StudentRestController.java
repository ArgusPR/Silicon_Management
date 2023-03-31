package com.example.school.rest;

import com.example.school.dto.StudentDTO;
import com.example.school.entity.Student;
import com.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student theStudent =studentService.findById(studentId);
        System.out.println(theStudent);
        if(theStudent == null) {
            throw new RuntimeException("Student id not found : "+studentId);
        }
        return theStudent;
    }

    @PostMapping("/students")
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
//        theStudent.setStudId(0);
        System.out.println(studentDTO);
        studentService.save(studentDTO);
        return studentDTO;
    }

//    @PutMapping("/students")
//    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
//        studentService.save(studentDTO);
//        return studentDTO;
//    }

    @PutMapping("/students/{studentId}")
    public StudentDTO updateStudent(@PathVariable int studentId, @RequestBody StudentDTO studentDTO) {
        studentDTO.setStudId(studentId);
        studentService.save(studentDTO);
        return studentDTO;
    }


    @DeleteMapping("/students/{studentId}")
    public Student deleteStudent(@PathVariable int studentId) {
        Student tempStudent = studentService.findById(studentId);

        if(tempStudent == null) {
            throw new RuntimeException("Student id not found.." + studentId);
        }
        Student theStudent =studentService.findById(studentId);
        studentService.deleteById(studentId);

        return theStudent;
//        return "Delete student id.. " +studentId;
    }
}
