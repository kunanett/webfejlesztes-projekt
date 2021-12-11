
package hu.unideb.inf.beer.service;

import java.util.List;

import hu.unideb.inf.beer.model.BeerCategory;

public interface BeerCategoryService {

    List<BeerCategory> findAll();

    BeerCategory getBeerCategory(BeerCategory beerCategory);

}