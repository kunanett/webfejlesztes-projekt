
package hu.unideb.inf.beer.service;

import java.util.List;

import hu.unideb.inf.beer.model.Beer;

public interface BeerService {
    Beer saveBeer(Beer beer);

    List<Beer> findAll();

    Beer findById(Beer beer);

    void deleteBeer(Beer beer);
}