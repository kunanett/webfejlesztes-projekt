package hu.unideb.inf.beer.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class BeerCategory implements Serializable {
    private Long id;
    private String name;
}
