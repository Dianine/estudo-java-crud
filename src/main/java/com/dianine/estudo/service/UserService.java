package com.dianine.estudo.service;

import com.dianine.estudo.exception.NotFoundException;
import com.dianine.estudo.model.User;
import com.dianine.estudo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll() {
        return repository.findAll();
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new NotFoundException("Usuário não existe"));
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }

    public User updateById(Long id, User user) {
        return repository.findById(id).map(u-> {
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setPassword(user.getPassword());
            return repository.save(u);
        }).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(()-> new NotFoundException("Email não cadastrado!"));
    }
}
