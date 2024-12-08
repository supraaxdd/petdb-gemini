package com.supra.petdbgemini;

import com.supra.petdbgemini.model.Household;
import com.supra.petdbgemini.dto.HouseholdDto;
import com.supra.petdbgemini.repository.HouseholdRepository;
import com.supra.petdbgemini.service.HouseholdServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HouseholdServiceTests {

    @InjectMocks
    private HouseholdServiceImpl householdService;

    @Mock
    private HouseholdRepository householdRepository;

    @Test
    public void testCreateHousehold() {
        Household household = Household.builder()
                .eircode("A1B2C3")
                .numberOfOccupants(2)
                .maxNumberOfOccupants(4)
                .ownerOccupied(true)
                .build();

        when(householdRepository.save(any(Household.class))).thenReturn(household);

        Household createdHousehold = householdService.createHousehold(
                new HouseholdDto("A1B2C3", 2, 4, true)
        );

        assertEquals(household, createdHousehold);
        verify(householdRepository, times(1)).save(any(Household.class));
    }

    @Test
    public void testGetHouseholdByEircode() {
        Household household = Household.builder()
                .eircode("A1B2C3")
                .numberOfOccupants(2)
                .maxNumberOfOccupants(4)
                .ownerOccupied(true)
                .build();

        when(householdRepository.findById("A1B2C3")).thenReturn(Optional.of(household));

        Household foundHousehold = householdService.getHouseholdByEircode("A1B2C3");

        assertEquals(household, foundHousehold);
    }

}