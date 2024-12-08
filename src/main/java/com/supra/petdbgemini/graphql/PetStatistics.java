package com.supra.petdbgemini.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetStatistics {
    private long totalPets;
    private double averageAge;
}