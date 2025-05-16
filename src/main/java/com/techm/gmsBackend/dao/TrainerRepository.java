package com.techm.gmsBackend.dao;

import com.techm.gmsBackend.entity.GymTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<GymTrainer, Long> {
    List<GymTrainer> findBySpecialtyIgnoreCase(String specialty);
}
