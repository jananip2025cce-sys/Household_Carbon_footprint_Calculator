package com.example.carbontrack.service;

import com.example.carbontrack.entity.Household;
import com.example.carbontrack.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {

    private final HouseholdRepository householdRepository;

    public HouseholdService(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    // CREATE
    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    // GET ALL
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    // GET SINGLE
    public Household getHouseholdById(Long id) {

        return householdRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Household not found with id: " + id));
    }

    // UPDATE
    public Household updateHousehold(Long id, Household updatedHousehold) {

        Household existing = getHouseholdById(id);

        existing.setName(updatedHousehold.getName());
        existing.setMembersCount(updatedHousehold.getMembersCount());
        existing.setLocation(updatedHousehold.getLocation());

        return householdRepository.save(existing);
    }

    // DELETE
    public void deleteHousehold(Long id) {

        Household existing = getHouseholdById(id);

        householdRepository.delete(existing);
    }
}