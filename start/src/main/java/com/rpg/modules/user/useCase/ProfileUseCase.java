package com.rpg.modules.user.useCase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rpg.modules.user.dto.RequestUserDTO;
import com.rpg.modules.user.repository.UserRepository;

public class ProfileUseCase {
    
    @Autowired
    private UserRepository repository;

    private RequestUserDTO dto; 

    public RequestUserDTO execute(UUID id){

        var candidateID = this.repository.findById(id)
            .orElseThrow(()->{
                throw new UsernameNotFoundException("User not found");
            });
        
        var candidate = this.dto.builder()
        .email(candidateID.getEmail())
        .username(candidateID.getUsername())
        .name(candidateID.getName())
        .role(candidateID.getRole())
        .id(candidateID.getId())
        .build();
        
        return candidate;
            



    }




}
