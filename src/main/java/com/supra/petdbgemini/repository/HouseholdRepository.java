package com.supra.petdbgemini.repository;

import com.supra.petdbgemini.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, String> {

    List<Household> findByPetsIsEmpty();

    List<Household> findByOwnerOccupiedIsTrue();

    @Query("SELECT h FROM Household h JOIN FETCH h.pets WHERE h.eircode = :eircode")
    public Household getHouseholdByEircodeWithPets(@Param("eircode") String eircode);

    @Query("SELECT h FROM Household h WHERE h.eircode = :eircode")
    public Household getHouseholdByEircode(@Param("eircode") String eircode);

    @Query("SELECT h FROM Household h WHERE h.pets IS EMPTY")
    public List<Household> getAllHouseholdsWithoutPets();

    @Query("SELECT h FROM Household h WHERE h.ownerOccupied = true")
    public List<Household> getOwnerOccupiedHouseholds();

    @Query("SELECT COUNT(h) FROM Household h WHERE h.numberOfOccupants = 0")
    public int countEmptyHouseholds();

    @Query("SELECT COUNT(h) FROM Household h WHERE h.numberOfOccupants = h.maxNumberOfOccupants")
    public int countFullHouseholds();
}