package com.example.petshop.service;

import com.example.petshop.model.PetList;

public interface PetService {

    public PetList getAllpets();
    public PetList addPet(PetList pets);
    public PetList getPetsByOwner(String ownerName);    
    
}
