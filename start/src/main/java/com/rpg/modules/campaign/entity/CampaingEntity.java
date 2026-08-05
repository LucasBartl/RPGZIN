package com.rpg.modules.campaign.entity;

import java.util.List;
import java.util.UUID;

import com.rpg.modules.player.entity.PlayerEntity;
import com.rpg.modules.user.entity.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "campaign")
public class CampaingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @NotNull
    private String title;

    private String history;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}