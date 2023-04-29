package com.example.sandwich.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class FlafelDto extends RepresentationModel<FlafelDto> {

    private int id;
    private int weight;
    private boolean hasTehena;
    private boolean hasSalad;
}
