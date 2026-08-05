package com.rpg.modules.player.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpg.modules.player.entity.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, UUID>{

    
} 
