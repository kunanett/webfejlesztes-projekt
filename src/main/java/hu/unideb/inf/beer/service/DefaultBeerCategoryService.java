package hu.unideb.inf.beer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.beer.entity.BeerCategoryEntity;
import hu.unideb.inf.beer.model.BeerCategory;
import hu.unideb.inf.beer.repository.BeerCategoryRepository;

@Service
@Transactional
public class DefaultBeerCategoryService implements BeerCategoryService {

    private final BeerCategoryRepository beerCategoryRepository;

    @Autowired
    public DefaultBeerCategoryService(BeerCategoryRepository beerCategoryRepository) {
        this.beerCategoryRepository = beerCategoryRepository;
    }

    @Override
    public List<BeerCategory> findAll() {
        List<BeerCategory> beerCategories = new ArrayList<>();
        List<BeerCategoryEntity> entities = beerCategoryRepository.findAll();

        entities.forEach(beerCategoryEntity -> {
            BeerCategory beerCategory = new BeerCategory();
            BeanUtils.copyProperties(beerCategoryEntity, beerCategory);
            beerCategories.add(beerCategory);
        });

        return beerCategories;
    }

    @Override
    public BeerCategory getBeerCategory(BeerCategory beerCategory) {
        System.out.println(">>>>> " + beerCategory.getName());
        BeerCategoryEntity entity = beerCategoryRepository.findByName(beerCategory.getName());
        BeerCategory updatedBeerCategory = new BeerCategory();

        BeanUtils.copyProperties(entity, updatedBeerCategory);
        return updatedBeerCategory;
    }
}