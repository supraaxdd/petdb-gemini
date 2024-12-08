package com.supra.petdbgemini.controller;

import com.supra.petdbgemini.dto.HouseholdDto;
import com.supra.petdbgemini.model.Household;
import com.supra.petdbgemini.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        return ResponseEntity.ok(householdService.getAllHouseholds());
    }

    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getHouseholdByEircode(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.getHouseholdByEircode(eircode));
    }

    @GetMapping("/{eircode}/without-pets")
    public ResponseEntity<Household> getHouseholdByEircodeWithoutPets(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.getHouseholdByEircodeWithoutPets(eircode));
    }

    @GetMapping("/{eircode}/with-pets")
    public ResponseEntity<Household> getHouseholdByEircodeWithPets(@PathVariable String eircode) {
        return ResponseEntity.ok(householdService.getHouseholdByEircodeWithPets(eircode));
    }

    @PostMapping
    public ResponseEntity<Household> createHousehold(@RequestBody HouseholdDto householdDto) {
        Household createdHousehold = householdService.createHousehold(householdDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHousehold);
    }

    @PutMapping("/{eircode}")
    public ResponseEntity<Household> updateHouseholdDetails(@PathVariable String eircode, @RequestBody HouseholdDto updatedHousehold) {
        Household updated = householdService.updateHouseholdDetails(eircode, updatedHousehold);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/without-pets")
    public ResponseEntity<List<Household>> getHouseholdsWithoutPets() {
        return ResponseEntity.ok(householdService.getHouseholdsWithoutPets());
    }

    @GetMapping("/owner-occupied")
    public ResponseEntity<List<Household>> getOwnerOccupiedHouseholds() {
        return ResponseEntity.ok(householdService.findOwnerOccupiedHouseholds());
    }

    @GetMapping("/empty")
    public ResponseEntity<Integer> countEmptyHouseholds() {
        return ResponseEntity.ok(householdService.countEmptyHouseholds());
    }

    @GetMapping("/full")
    public ResponseEntity<Integer> countFullHouseholds() {
        return ResponseEntity.ok(householdService.countFullHouseholds());
    }
}