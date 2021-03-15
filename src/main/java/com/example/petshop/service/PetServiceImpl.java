package com.example.petshop.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.example.petshop.model.Pet;
import com.example.petshop.model.PetList;
import com.example.petshop.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository petRepository;


    @Override
    public PetList getAllpets() {
        return new PetList(petRepository.findAll());

    }


    @Override
    public PetList addPet(PetList pets) {
        
        for (Pet pet : pets.getPets()) {
            pet.setDateOfCreation(Timestamp.valueOf(LocalDateTime.now()));
            pet = petRepository.save(pet);
        }
        return pets;
    }

    @Override
    public PetList getPetsByOwner(String ownerName) {
        
        return new PetList(petRepository.findPetsByOwner(ownerName));
    }

    
}
