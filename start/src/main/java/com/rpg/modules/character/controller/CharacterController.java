package com.rpg.modules.character.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/character")
public class CharacterController {

    @PostMapping("/create")
    public String postMethodName(@RequestBody String entity) {
        
        return entity;
    }
    
    

}
