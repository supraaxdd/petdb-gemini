package com.supra.petdbgemini;

import com.supra.petdbgemini.model.Pet;
import com.supra.petdbgemini.dto.PetDto;
import com.supra.petdbgemini.repository.PetRepository;
import com.supra.petdbgemini.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PetServiceTests {

    @InjectMocks
    private PetServiceImpl petService;

    @Mock
    private PetRepository petRepository;

    @Test
    public void testCreatePet() {
        Pet pet = Pet.builder()
                .name("Buddy")
                .animalType("Dog")
                .breed("Golden Retriever")
                .age(5)
                .build();

        when(petRepository.save(any(Pet.class))).thenReturn(pet);

        Pet createdPet = petService.createPet(
                new PetDto("Buddy", "Dog", "Golden Retriever", 5, "A1B2C3")
        );

        assertEquals(pet, createdPet);
        verify(petRepository, times(1)).save(any(Pet.class));
    }

    @Test
    public void testGetPetById() {
        Pet pet = Pet.builder()
                .id(1L)
                .name("Buddy")
                .animalType("Dog")
                .breed("Golden Retriever")
                .age(5)
                .build();

        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));

        Pet foundPet = petService.getPetById(1L);

        assertEquals(pet, foundPet);
    }

}