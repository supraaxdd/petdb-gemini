package com.supra.petdbgemini.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HouseholdStatistics {
    private long emptyHouseholds;
    private long fullHouseholds;
}