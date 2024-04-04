package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.dto.ExceptionsDTO;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update (Long id, User user){
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()){
            User newUser = optionalUser.get();
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setFone(user.getFone());
            return repository.save(newUser);
        }
        throw new EntityNotFoundException();
    }
}
