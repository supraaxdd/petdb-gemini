package com.supra.petdbgemini.service;

import com.supra.petdbgemini.dto.PetDto;
import com.supra.petdbgemini.model.Pet;
import com.supra.petdbgemini.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Override
    public Pet createPet(PetDto petDto) {
        Pet pet = new Pet();
        pet.setName(petDto.getName());
        pet.setAnimalType(petDto.getAnimalType());
        pet.setBreed(petDto.getBreed());
        pet.setAge(petDto.getAge());
        return petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found"));
    }

    @Override
    public void updatePet(Long id, Pet pet) {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found"));

        existingPet.setName(pet.getName());
        existingPet.setAnimalType(pet.getAnimalType());
        existingPet.setBreed(pet.getBreed());
        existingPet.setAge(pet.getAge());
        existingPet.setHousehold(pet.getHousehold());

        petRepository.save(existingPet);
    }

    @Override
    public void updatePetName(Long id, String name) {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found"));

        existingPet.setName(name);
        petRepository.save(existingPet);
    }

    @Override
    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public void deletePetByName(String name) {
        petRepository.deletePetByName(name);
    }

    @Override
    public List<Pet> getPetsByType(String type) {
        return petRepository.getPetsByType(type);
    }

    @Override
    public List<Pet> getPetsByBreed(String breed) {
        return petRepository.getPetsByBreed(breed);
    }

    @Override
    public int getTotalPetCount() {
        return petRepository.getTotalCount();
    }
}