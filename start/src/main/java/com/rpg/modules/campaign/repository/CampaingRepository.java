package com.rpg.modules.campaign.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpg.modules.campaign.entity.CampaingEntity;


public interface CampaingRepository extends JpaRepository<CampaingEntity, UUID>{
     
}
