package com.example.petshop.controller;

import java.util.List;

import com.example.petshop.model.Pet;
import com.example.petshop.model.PetList;
import com.example.petshop.service.PetService;
import com.example.petshop.service.PetServiceImpl;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("petshop")
public class PetShopController {
    
    @Autowired
    private PetServiceImpl petService;

    @GetMapping("/pets/")
    public ResponseEntity<PetList> getAllPets() {
        return ResponseEntity.ok().body(petService.getAllpets());
    }

    @GetMapping("/pets")
    public ResponseEntity<PetList> getAllPetsByOwnerName(
        @RequestParam String ownerName ) {

        if ((ownerName == null || ownerName.isEmpty())) {
            return ResponseEntity.badRequest().build();
        }
        PetList list = petService.getPetsByOwner(ownerName);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/pets/add") 
    public ResponseEntity<PetList> postPet(
        @RequestBody PetList pets ) {
        pets = petService.addPet(pets);
        return ResponseEntity.ok(pets);
        
    }
}
