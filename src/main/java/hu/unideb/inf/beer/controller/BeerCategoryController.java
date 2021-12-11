package hu.unideb.inf.beer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import hu.unideb.inf.beer.model.BeerCategory;
import hu.unideb.inf.beer.service.BeerCategoryService;

@Controller
@SessionScope
public class BeerCategoryController {

    private final BeerCategoryService beerCategoryService;
    private List<BeerCategory> beerCategories;

    @Autowired
    public BeerCategoryController(BeerCategoryService beerCategoryService) {
        this.beerCategoryService = beerCategoryService;
    }

    @PostConstruct
    public void findAll() {
        if (!this.getBeerCategories().isEmpty()) {
            this.getBeerCategories().clear();
        }
        this.getBeerCategories().addAll(beerCategoryService.findAll());
    }

    public List<BeerCategory> getBeerCategories() {
        if (null == beerCategories) {
            beerCategories = new ArrayList<>();
        }
        return beerCategories;
    }
}
