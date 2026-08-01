package com.rpg.modules.user.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rpg.exceptions.UserFoundException;
import com.rpg.modules.user.dto.UserDTO;
import com.rpg.modules.user.entity.UserEntity;
import com.rpg.modules.user.repository.UserRepository;

@Service
public class CreateUserUseCase {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    
    public UserEntity execute(UserEntity entity){

        this.repository.findByUsernameOrEmail(entity.getUsername(), entity.getEmail())
            .ifPresent((user) -> {
                throw new UserFoundException("Data already in use by another user");
            });

        var password = this.encoder.encode(entity.getPassword());
        entity.setPassword(password);
        

        return this.repository.save(entity);
        


    }



}
