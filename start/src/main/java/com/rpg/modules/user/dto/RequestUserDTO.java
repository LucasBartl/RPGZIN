package com.rpg.modules.user.dto;

import lombok.Data;

@Data
public class RequestUserDTO {
    
    private String username;
    private String email;
    private String password;
    private String role;


}
