package com.lucasangelo.todosimple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasangelo.todosimple.repositories.UserRepository;

import jakarta.transaction.Transactional;

import com.lucasangelo.todosimple.models.User;
import java.util.Optional;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User findById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
            "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()
        ));
    }
    
    @Transactional
    public User create(User obj){
        obj.setId(null);
        obj = this.userRepository.save(obj);
        return obj;

    }

    @Transactional
    public User update(User obj){
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        newObj.setUsername(obj.getUsername());
        newObj.setBalance(obj.getBalance());
        obj = this.userRepository.save(obj);
        return this.userRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.userRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas.");

        }
    }
}
