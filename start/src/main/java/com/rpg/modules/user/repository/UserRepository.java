package com.rpg.modules.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpg.modules.user.entity.UserEntity;

public interface UserRepository  extends JpaRepository<UserEntity,UUID >{
    Optional<UserEntity>findByUsernameOrEmail(String username, String email);
}
