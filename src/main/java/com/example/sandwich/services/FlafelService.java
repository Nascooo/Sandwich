package com.example.sandwich.services;

import com.example.sandwich.controllers.SandwichController;
import com.example.sandwich.entities.Flafel;
import com.example.sandwich.reposoteries.FlafelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class FlafelService {


    @Autowired
    private FlafelRepo flafelRepo;

    public List<Flafel> findAll() {
        List<Flafel> all = flafelRepo.findAll();
        return all;
    }

    public Flafel findById(Integer id) {
        return flafelRepo
                .findById(id)
                .map(item -> item.add(linkTo(methodOn(SandwichController.class)
                        .get(item.getId())).withSelfRel())).orElse(null);

    }
}


