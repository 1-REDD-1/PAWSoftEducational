package com.pawsoftedu.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pawsoftedu.demo.entities.MaterialCurs;
import com.pawsoftedu.demo.repositories.MaterialCursRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/materialcurs")
public class MaterialCursController {
    @Autowired
    MaterialCursRepository repository;

    @GetMapping("/{id}")
    public Optional<MaterialCurs> getMaterialCurs (@PathVariable long id) {
        return repository.findById(id);
    }

    @GetMapping("/toate")
	public List<MaterialCurs> getToateMaterialeleDeCurs () {
		return repository.findAll();
	}

    @PostMapping("/adauga")
    public MaterialCurs adaugaMaterialCurs (@RequestBody MaterialCurs material) {
        return repository.save(material);
    }
}
