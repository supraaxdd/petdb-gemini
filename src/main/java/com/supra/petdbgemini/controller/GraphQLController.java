package com.supra.petdbgemini.controller;

import com.supra.petdbgemini.dto.HouseholdDto;
import com.supra.petdbgemini.dto.PetDto;
import com.supra.petdbgemini.model.Household;
import com.supra.petdbgemini.model.Pet;
import com.supra.petdbgemini.service.HouseholdService;
import com.supra.petdbgemini.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GraphQLController {

    private final PetService petService;
    private final HouseholdService householdService;

    @QueryMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @QueryMapping
    public Pet getPetById(@Argument Long id) {
        return petService.getPetById(id);
    }

    @QueryMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @QueryMapping
    public Household getHouseholdByEircode(@Argument String eircode) {
        return householdService.getHouseholdByEircode(eircode);
    }

    @QueryMapping
    public Integer getPetCount() {
        return petService.getTotalPetCount();
    }

    @MutationMapping
    public Pet createPet(@Argument PetDto petDto) {
        return petService.createPet(petDto);
    }

    @MutationMapping
    public Household createHousehold(@Argument HouseholdDto householdDto) {
        return householdService.createHousehold(householdDto);
    }

    @MutationMapping
    public Boolean deletePet(@Argument Long id) {
        petService.deletePetById(id);
        return true;
    }

    @MutationMapping
    public Boolean deleteHousehold(@Argument String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return true;
    }
}