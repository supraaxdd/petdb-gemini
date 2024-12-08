package com.supra.petdbgemini.service;

import com.supra.petdbgemini.dto.HouseholdDto;
import com.supra.petdbgemini.model.Household;
import com.supra.petdbgemini.repository.HouseholdRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdRepository householdRepository;

    @Override
    public Household createHousehold(HouseholdDto householdDto) {
        Household household = new Household();
        household.setEircode(householdDto.getEircode());
        household.setNumberOfOccupants(householdDto.getNumberOfOccupants());
        household.setMaxNumberOfOccupants(householdDto.getMaxNumberOfOccupants());
        household.setOwnerOccupied(householdDto.isOwnerOccupied());
        return householdRepository.save(household);
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Household getHouseholdByEircode(String eircode) {
        return householdRepository.findById(eircode)
                .orElseThrow(() -> new EntityNotFoundException("Household not found with eircode: " + eircode));
    }

    @Override
    public Household getHouseholdByEircodeWithoutPets(String eircode) {
        return householdRepository.getHouseholdByEircode(eircode);
    }

    @Override
    public Household getHouseholdByEircodeWithPets(String eircode) {
        return householdRepository.getHouseholdByEircodeWithPets(eircode);
    }

    @Override
    public Household updateHouseholdDetails(String eircode, HouseholdDto updatedHousehold) {
        Household existingHousehold = householdRepository.findById(eircode)
                .orElseThrow(() -> new EntityNotFoundException("Household not found with eircode: " + eircode));

        if (updatedHousehold.getMaxNumberOfOccupants() < existingHousehold.getNumberOfOccupants()) {
            throw new IllegalArgumentException("Max occupants cannot be less than current number of occupants");
        }

        existingHousehold.setMaxNumberOfOccupants(updatedHousehold.getMaxNumberOfOccupants());
        existingHousehold.setNumberOfOccupants(updatedHousehold.getNumberOfOccupants());
        existingHousehold.setOwnerOccupied(updatedHousehold.isOwnerOccupied());

        return householdRepository.save(existingHousehold);
    }

    @Override
    public void deleteHouseholdByEircode(String eircode) {
        householdRepository.deleteById(eircode);
    }

    @Override
    public List<Household> getHouseholdsWithoutPets() {
        return householdRepository.getAllHouseholdsWithoutPets();
    }

    @Override
    public List<Household> findOwnerOccupiedHouseholds() {
        return householdRepository.getOwnerOccupiedHouseholds();
    }

    @Override
    public int countEmptyHouseholds() {
        return householdRepository.countEmptyHouseholds();
    }

    @Override
    public int countFullHouseholds() {
        return householdRepository.countFullHouseholds();
    }
}