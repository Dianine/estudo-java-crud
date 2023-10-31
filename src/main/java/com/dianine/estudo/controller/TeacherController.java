package com.dianine.estudo.controller;

import com.dianine.estudo.model.Teacher;
import com.dianine.estudo.service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/teacher")
@AllArgsConstructor
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeacher(@RequestBody @Valid Teacher teacher){
        service.saveTeacher(teacher);
    }

    @GetMapping("/teachers")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Teacher findById(@PathVariable ("id") Long id){
        return service.findById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Teacher updateTeacher(@PathVariable ("id") Long id, @RequestBody Teacher teacher){
        return service.updateTeacher(teacher, id);
    }

}
