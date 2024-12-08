package com.supra.petdbgemini.controller;

import com.supra.petdbgemini.dto.PetDto;
import com.supra.petdbgemini.model.Pet;
import com.supra.petdbgemini.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody PetDto petDto) {
        Pet createdPet = petService.createPet(petDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        petService.updatePet(id, pet);
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Pet>> getPetsByType(@PathVariable String type) {
        return ResponseEntity.ok(petService.getPetsByType(type));
    }

    @GetMapping("/breed/{breed}")
    public ResponseEntity<List<Pet>> getPetsByBreed(@PathVariable String breed) {
        return ResponseEntity.ok(petService.getPetsByBreed(breed));
    }
}