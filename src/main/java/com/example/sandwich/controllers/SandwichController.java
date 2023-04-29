package com.example.sandwich.controllers;

import com.example.sandwich.entities.Flafel;
import com.example.sandwich.services.FlafelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {

    @Autowired
    private FlafelService flafelService;

    @GetMapping("flafel")
    public ResponseEntity<List<Flafel>> getAll() {
        List<Flafel> all = flafelService.findAll();
        List<Flafel> collect = new ArrayList<>();
        for (Flafel item : all) {
            item.add(linkTo(methodOn(SandwichController.class).get(item.getId())).withSelfRel());
            collect.add(item);
        }
        return ResponseEntity.ok(collect);
    }

    @GetMapping("flafel/{id}")
    public ResponseEntity<Flafel> get(@PathVariable("id") Integer id) {
        Flafel flafel = flafelService.findById(id);
        if (flafel == null) {
            return new ResponseEntity<Flafel>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(flafel);
    }


}
