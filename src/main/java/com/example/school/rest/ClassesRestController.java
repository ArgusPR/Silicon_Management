package com.example.school.rest;

import com.example.school.dto.ClassesDTO;
import com.example.school.entity.Classes;
import com.example.school.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/api")
public class ClassesRestController {
    private ClassesService classesService;

    @Autowired
    public ClassesRestController(ClassesService theClassesService) {
        classesService = theClassesService;
    }

    @GetMapping("/classes")
    public List<Classes> findAll() {
        return classesService.findAll();
    }

    @GetMapping("/classes/{classesId}")
    public Classes getClasses(@PathVariable int classesId) {
        Classes theClasses =classesService.findById(classesId);
        System.out.println(theClasses);
        if(theClasses == null) {
            throw new RuntimeException("Class id not found : "+classesId);
        }
        return theClasses;
    }

    @PostMapping("/classes")
    public ClassesDTO addClasses(@RequestBody ClassesDTO classesDTO) {
        System.out.println(classesDTO);
        classesService.save(classesDTO);
        return classesDTO;
    }

    @PutMapping("/classes/{classesId}")
    public ClassesDTO updateClasses(@PathVariable int classesId, @RequestBody ClassesDTO classesDTO) {
        classesDTO.setClassId(classesId);
        classesService.save(classesDTO);
        return classesDTO;
    }

    @DeleteMapping("/classes/{classesId}")
    public Classes deleteClasses(@PathVariable int classesId) {
        Classes tempClasses = classesService.findById(classesId);

        if(tempClasses == null) {
            throw new RuntimeException("Class id not found.." + classesId);
        }
        Classes theClasses =classesService.findById(classesId);
        classesService.deleteById(classesId);

        return theClasses;
    }
}
