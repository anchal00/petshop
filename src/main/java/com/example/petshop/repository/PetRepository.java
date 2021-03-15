package com.example.petshop.repository;

import java.util.List;

import com.example.petshop.model.Pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PetRepository extends JpaRepository<Pet, Long> {
    
    @Query(value = "select * from pets where name = ?1", nativeQuery = true)
    public List<Pet> findPetsByName(String petName);

    @Query(value = "select * from pets where owner_name = ?1", nativeQuery = true) 
    public List<Pet> findPetsByOwner(String ownerName);
}
