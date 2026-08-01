package com.rpg.modules.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.modules.user.entity.UserEntity;
import com.rpg.modules.user.useCase.CreateUserUseCase;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserUseCase useCase;

    @PostMapping("/create")
    public ResponseEntity postMethodName(@Valid @RequestBody UserEntity entity) {

        try {

            var userCreate = this.useCase.execute(entity);
            return ResponseEntity.ok().body(userCreate);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

}
