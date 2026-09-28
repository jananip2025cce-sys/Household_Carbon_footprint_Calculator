package com.example.carbontrack.controller;

import com.example.carbontrack.entity.Household;
import com.example.carbontrack.repository.HouseholdRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    private final HouseholdRepository repository;

    public HouseholdController(HouseholdRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Household addHousehold(@RequestBody Household household) {
        return repository.save(household);
    }

    @GetMapping
    public List<Household> getAllHouseholds() {
        return repository.findAll();
    }
}