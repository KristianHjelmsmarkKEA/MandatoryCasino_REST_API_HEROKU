package com.example.demo.controllers;

import com.example.demo.models.Casino;
import com.example.demo.repositories.CasinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Casinos {

    @Autowired
    CasinoRepository casinos;

    @GetMapping("/casinos")
    public Iterable<Casino> getCasino() {
        return casinos.findAll();
    }

    @GetMapping("/casinos/{id}")
    public Casino getCasinoById(@PathVariable Long id) {
        return casinos.findById(id).get();
    }


    @PostMapping("/casinos")
    public Casino addCasino(@RequestBody Casino newCasino) {
        return casinos.save(newCasino);
    }


    @PutMapping
    public String updateCasino(@PathVariable Long id, @RequestBody Casino casinoToUpdate) {
        if(casinos.existsById(id)) {
            casinoToUpdate.setId(id);
            casinos.save(casinoToUpdate);
            return "Casino was updated";
        } else {
            return "Casino not found";
        }
    }

    @PatchMapping("/casinos/{id}")
    public String patchCasino(@PathVariable Long id, @RequestBody Casino casinoToUpdate) {
        return casinos.findById(id).map( foundCasino -> {
            if(casinoToUpdate.getName() != null) foundCasino.setName(casinoToUpdate.getName());
            if(casinoToUpdate.getCountry() != null) foundCasino.setCountry(casinoToUpdate.getCountry());
            if(casinoToUpdate.getEntry_price() != 0) foundCasino.setEntry_price(casinoToUpdate.getEntry_price());
            if(casinoToUpdate.getBest_drink() != null) foundCasino.setBest_drink(casinoToUpdate.getBest_drink());
            if(casinoToUpdate.getMain_game() != null) foundCasino.setMain_game(casinoToUpdate.getMain_game());
            casinos.save(foundCasino);
            return "Casino updated";
        }).orElse("Casino not found");
    }

    @DeleteMapping("/casinos/{id}")
    public void deleteCasinoById(@PathVariable Long id) {
        casinos.deleteById(id);
    }

}
