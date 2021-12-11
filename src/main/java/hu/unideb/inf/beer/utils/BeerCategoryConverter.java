package hu.unideb.inf.beer.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.unideb.inf.beer.model.BeerCategory;
import hu.unideb.inf.beer.service.BeerCategoryService;

@Service
public class BeerCategoryConverter implements Converter {

    @Autowired
    private BeerCategoryService beerCategoryService;

    private static final Logger LOG = LoggerFactory.getLogger(BeerCategoryConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        LOG.info("getAsObject: " + beerCategoryService);
        BeerCategory beerCategory = new BeerCategory();
        beerCategory.setName(string);
        beerCategory = beerCategoryService.getBeerCategory(beerCategory);
        return beerCategory;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        LOG.info("getAsString obj class: " + obj.getClass().getName());
        if (obj instanceof BeerCategory) {
            BeerCategory beerCategory = (BeerCategory) obj;
            LOG.info("getAsString def name: " + beerCategory.getName());
            return beerCategory.getName();
        } else {
            throw new ClassCastException("The object of class " + obj.getClass().getName() + " is not of BeerCategory");
        }
    }
}