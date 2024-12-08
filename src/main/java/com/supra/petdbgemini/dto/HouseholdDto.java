package com.supra.petdbgemini.dto;

import com.supra.petdbgemini.validation.ValidEircodeConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseholdDto {
    @ValidEircodeConstraint
    private String eircode;

    @Min(value = 0, message = "Number of Occupants must be greater than or equal to 0")
    private Integer numberOfOccupants;

    @Max(10)
    private Integer maxNumberOfOccupants;

    private boolean ownerOccupied;
}