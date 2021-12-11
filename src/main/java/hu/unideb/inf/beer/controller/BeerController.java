package hu.unideb.inf.beer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import hu.unideb.inf.beer.model.Beer;
import hu.unideb.inf.beer.model.BeerCategory;
import hu.unideb.inf.beer.service.BeerCategoryService;
import hu.unideb.inf.beer.service.BeerService;

@Controller
@SessionScope
public class BeerController {

    private final BeerService beerService;
    private final BeerCategoryService beerCategoryService;

    @Autowired
    public BeerController(BeerService beerService, BeerCategoryService beerCategoryService) {
        this.beerCategoryService = beerCategoryService;
        this.beerService = beerService;
    }

    private String actionLabel;
    private Beer beer;
    private List<Beer> beerList;
    private List<BeerCategory> beerCategories;

    public void saveBeer() {
        System.out.println("Saving: " + this.getBeer());
        beerService.saveBeer(this.getBeer());
        findAll();
        this.setBeer(new Beer());
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Beer Details", "Beer Details added/Updated Successfully."));
    }

    @PostConstruct
    public void findAll() {
        if (!this.getBeerList().isEmpty()) {
            this.getBeerList().clear();
            this.getBeerCategories().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + beerService);
        this.getBeerList().addAll(beerService.findAll());
        this.getBeerCategories().addAll(beerCategoryService.findAll());
        this.setActionLabel("Add");
    }

    public void delete(Beer beer) {
        System.out.println(beer + "deleted");
        beerService.deleteBeer(beer);
        findAll();
    }

    public void edit(Beer beer) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(beer, this.getBeer());
        System.out.println(this.getBeer());
    }

    public Beer getBeer() {
        if (beer == null) {
            beer = new Beer();
        }
        return beer;
    }

    public void setBeer(Beer b) {
        this.beer = b;
    }

    public List<Beer> getBeerList() {
        if (null == beerList) {
            beerList = new ArrayList<>();
        }
        return beerList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public List<BeerCategory> getBeerCategories() {
        if (beerCategories == null) {
            beerCategories = new ArrayList<>();
        }
        return beerCategories;
    }

    public void setBeerCategories(List<BeerCategory> beerCategories) {
        this.beerCategories = beerCategories;
    }
}