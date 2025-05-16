package com.techm.gmsBackend.controller;

import com.techm.gmsBackend.entity.GymTrainer;
import com.techm.gmsBackend.service.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/add-update")
    public String addOrUpdateTrainer(@RequestBody GymTrainer trainer) {
        return trainerService.createOrUpdateTrainer(trainer);
    }

    @GetMapping("/get-all")
    public List<GymTrainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/get-id/{id}")
    public GymTrainer getTrainerById(@PathVariable long id) {
        return trainerService.getTrainer(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public String deleteTrainerById(@PathVariable long id) {
        return trainerService.deleteTrainer(id);
    }

    @GetMapping("/get-specialty/{specialty}")
    public List<GymTrainer> getTrainerBySpecialty(@PathVariable String specialty) {
        return trainerService.getTrainersBySpecialty(specialty);
    }
}
