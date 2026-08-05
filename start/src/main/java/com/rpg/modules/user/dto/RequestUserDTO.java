package com.rpg.modules.user.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor

public class RequestUserDTO {
    private UUID id; 
    private String username;
    private String name;
    private String email;
    private String password;
    private String role;


}
