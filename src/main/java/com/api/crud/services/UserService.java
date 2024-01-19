package com.api.crud.services;

import com.api.crud.models.User;
import com.api.crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public List<User> getUsers(){
        return iUserRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return iUserRepository.findById(id);
    }

    public User saveUser(User user) {
        return iUserRepository.save(user);
    }

    public Optional<User> updateById(User request, Long id){
        Optional<User> userOptional = iUserRepository.findById(id);

        userOptional.ifPresent(user -> {
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
        });

        return userOptional;
    }

    public Boolean deleteUser(Long id){
        try{
            iUserRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
