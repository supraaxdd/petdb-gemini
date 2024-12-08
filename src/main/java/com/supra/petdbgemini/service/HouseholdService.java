package com.supra.petdbgemini.service;

import com.supra.petdbgemini.dto.HouseholdDto;
import com.supra.petdbgemini.model.Household;

import java.util.List;

public interface HouseholdService {

    Household createHousehold(HouseholdDto household);
    List<Household> getAllHouseholds();
    Household getHouseholdByEircode(String eircode);
    Household getHouseholdByEircodeWithoutPets(String eircode);
    Household getHouseholdByEircodeWithPets(String eircode);
    Household updateHouseholdDetails(String eircode, HouseholdDto updatedHousehold);
    void deleteHouseholdByEircode(String eircode);
    List<Household> getHouseholdsWithoutPets();
    List<Household> findOwnerOccupiedHouseholds();
    int countEmptyHouseholds();
    int countFullHouseholds();
}