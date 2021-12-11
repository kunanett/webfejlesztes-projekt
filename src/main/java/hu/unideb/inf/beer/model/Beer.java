package hu.unideb.inf.beer.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Beer implements Serializable {
    private Long id;
    private String name;
    private double alcoholLevel;
    private double price;
    private BeerCategory beerCategory;
}
