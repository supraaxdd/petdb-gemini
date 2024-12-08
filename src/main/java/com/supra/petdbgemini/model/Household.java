package com.supra.petdbgemini.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "households")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Household {

    @Id
    private String eircode;

    @Column(nullable = false)
    private Integer numberOfOccupants;

    @Column(nullable = false)
    private Integer maxNumberOfOccupants;

    @Column(nullable = false)
    private Boolean ownerOccupied;

    @OneToMany(mappedBy = "household", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pet> pets;
}