package com.example.sandwich.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "FLAFEL")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Flafel extends RepresentationModel<Flafel> {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int weight;
    private boolean hasTehena;
    private boolean hasSalad;


    @JsonCreator
    public Flafel(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("weight") int weight, @JsonProperty("hasTehena") boolean hasTehena,
                  @JsonProperty("hasSalad") boolean hasSalad) {
        this.id = id;
        this.weight = weight;
        this.hasTehena = hasTehena;
        this.hasSalad = hasSalad;
        this.name = name;
    }
}
