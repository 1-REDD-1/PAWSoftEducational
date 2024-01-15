package com.pawsoftedu.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pawsoftedu.demo.entities.Utilizator;
import com.pawsoftedu.demo.repositories.UtilizatorRepository;

@RestController
public class UtilizatorController {
    @Autowired
    UtilizatorRepository repository;

    // @GetMapping("/utilizator/get")
    // public Utilizator getUtilizator () {
    //     return UtilizatorRepository.find();
    // }

    @PostMapping("/utilizator")
	public Utilizator creeazaUtilizator (@RequestBody Utilizator utilizator) {
		return repository.save(utilizator);
	}
}
