package com.supra.petdbgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.supra.petdbgemini.model.Pet;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByAnimalType(String animalType);

    @Query("SELECT p FROM Pet p WHERE p.age > :age")
    List<Pet> findPetsOlderThan(@Param("age") Integer age);

    @Modifying
    @Query("DELETE FROM Pet p WHERE LOWER(p.name) = LOWER(:name)")
    void deletePetByName(@Param("name") String name);

    @Query("SELECT p FROM Pet p WHERE p.animalType = :type")
    List<Pet> getPetsByType(@Param("type") String type);

    @Query("SELECT p FROM Pet p WHERE p.breed = :breed")
    List<Pet> getPetsByBreed(@Param("breed") String breed);

    @Query("SELECT COUNT(*) FROM Pet p")
    int getTotalCount();
}
