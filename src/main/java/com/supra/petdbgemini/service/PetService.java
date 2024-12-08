package com.supra.petdbgemini.service;

import com.supra.petdbgemini.dto.PetDto;
import com.supra.petdbgemini.model.Pet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetService {
    Pet createPet(PetDto pet);
    List<Pet> getAllPets();
    Pet getPetById(Long id);
    void updatePet(Long id, Pet pet);
    void updatePetName(Long id, String name);
    void deletePetById(Long id);
    void deletePetByName(String name);
    List<Pet> getPetsByType(String type);
    List<Pet> getPetsByBreed(String breed);
    int getTotalPetCount();
}