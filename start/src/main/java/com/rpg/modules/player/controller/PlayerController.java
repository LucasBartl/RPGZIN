package com.rpg.modules.player.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/character")
public class PlayerController {

    @PostMapping("/create")
    public String postMethodName(@RequestBody String entity) {
        
        return entity;
    }
    
    

}
