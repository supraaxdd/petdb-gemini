package com.supra.petdbgemini.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Animal type cannot be blank")
    private String animalType;

    @NotBlank(message = "Breed cannot be blank")
    private String breed;

    @Min(value = 0, message = "Age must be greater than or equal to 0")
    private int age;

    @NotBlank(message = "Household Eircode cannot be blank")
    private String householdEircode;
}