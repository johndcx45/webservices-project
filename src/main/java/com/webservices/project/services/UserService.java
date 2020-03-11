package com.webservices.project.services;

import com.webservices.project.entities.User;
import com.webservices.project.repositories.UserRepository;
import com.webservices.project.services.exceptions.DatabaseException;
import com.webservices.project.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
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


    public User insertUser(User user){
        return repository.save(user);
    }

    public void deleteUser(Long id){
        try {
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User updateUser(Long id, User obj){
        User entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
