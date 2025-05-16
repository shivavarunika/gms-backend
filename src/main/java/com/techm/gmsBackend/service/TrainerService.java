package com.techm.gmsBackend.service;

import com.techm.gmsBackend.dao.TrainerRepository;
import com.techm.gmsBackend.entity.GymTrainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public String createOrUpdateTrainer(GymTrainer trainer) {
        trainerRepository.save(trainer);
        return "trainer created/updated";
    }

    public List<GymTrainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public GymTrainer getTrainer(long id) {
        return trainerRepository.findById(id).orElse(null);
    }

    public String deleteTrainer(long id) {
        trainerRepository.deleteById(id);
        return "trainer deleted";
    }

    public List<GymTrainer> getTrainersBySpecialty(String specialty) {
        return trainerRepository.findBySpecialtyIgnoreCase(specialty);
    }
}
