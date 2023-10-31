package com.dianine.estudo.service;

import com.dianine.estudo.exception.NotFoundException;
import com.dianine.estudo.model.Teacher;
import com.dianine.estudo.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public void saveTeacher(Teacher teacher) {
        repository.save(teacher);
    }

    public List<Teacher> findAll() {
        return repository.findAll();
    }

    public Teacher findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Professor não encontrado!"));
    }

    public Teacher updateTeacher(Teacher teacher, Long id) {
        return repository.findById(id).map(t -> {
            t.setName(teacher.getName());
            t.setDiscipline(teacher.getDiscipline());
            return repository.save(t);
        }).orElseThrow(()-> new NotFoundException("Professor não encontrado!"));
    }
}
