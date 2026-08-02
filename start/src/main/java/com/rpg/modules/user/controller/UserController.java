package com.rpg.modules.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.modules.user.dto.RequestUserDTO;
import com.rpg.modules.user.dto.ResponseUserDTO;
import com.rpg.modules.user.entity.UserEntity;
import com.rpg.modules.user.useCase.CreateJWTUser;
import com.rpg.modules.user.useCase.CreateUserUseCase;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserUseCase useCase;

    @Autowired
    private CreateJWTUser jwt;

    @PostMapping("/create")
    public ResponseEntity postMethodName(@Valid @RequestBody UserEntity entity) {

        try {

            var userCreate = this.useCase.execute(entity);
            return ResponseEntity.ok().body(userCreate);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }
    @PostMapping("/auth")
    public ResponseUserDTO auth(@RequestBody RequestUserDTO dto) {
        var authUser = this.jwt.execute(dto);

        return authUser;
    }
    

}
