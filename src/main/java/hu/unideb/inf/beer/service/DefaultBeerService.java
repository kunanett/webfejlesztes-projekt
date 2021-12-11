package hu.unideb.inf.beer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.beer.entity.BeerCategoryEntity;
import hu.unideb.inf.beer.entity.BeerEntity;
import hu.unideb.inf.beer.model.Beer;
import hu.unideb.inf.beer.model.BeerCategory;
import hu.unideb.inf.beer.repository.BeerRepository;

@Service
@Transactional
public class DefaultBeerService implements BeerService {

    private final BeerRepository beerRepository;

    @Autowired
    public DefaultBeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    @Transactional
    public Beer saveBeer(Beer beer) {
        BeerEntity beerEntity = beerToEntity(beer);
        beerEntity = beerRepository.save(beerEntity);
        BeanUtils.copyProperties(beerEntity, beer);

        entityToBeer(beer, beerEntity);
        return beer;
    }

    private void entityToBeer(Beer beer, BeerEntity entity) {
        BeerCategory beerCategory = new BeerCategory();
        BeanUtils.copyProperties(entity.getBeerCategoryEntity(), beerCategory);
        beer.setBeerCategory(beerCategory);
    }

    private BeerEntity beerToEntity(Beer beer) {
        BeerEntity beerEntity = new BeerEntity();
        BeerCategoryEntity beerCategoryEntity = new BeerCategoryEntity();
        BeanUtils.copyProperties(beer, beerEntity);
        BeanUtils.copyProperties(beer.getBeerCategory(), beerCategoryEntity);
        beerEntity.setBeerCategoryEntity(beerCategoryEntity);
        return beerEntity;
    }

    @Override
    public List<Beer> findAll() {
        List<BeerEntity> beerEntities = beerRepository.findAll();
        List<Beer> beerList = new ArrayList<>();
        beerEntities.forEach(beerEntity -> {
            Beer beer = new Beer();
            System.out.println(beerEntity.getBeerCategoryEntity());
            BeanUtils.copyProperties(beerEntity, beer);
            entityToBeer(beer, beerEntity);
            beerList.add(beer);
        });
        return beerList;
    }

    @Override
    public Beer findById(Beer beer) {
        if (null != beer.getName()) {
            BeerEntity beerEntity = new BeerEntity();

            BeanUtils.copyProperties(beer, beerEntity);
            beerEntity = beerRepository.getOne(beerEntity.getId());

            BeanUtils.copyProperties(beerEntity, beer);
        }
        return beer;
    }

    @Override
    @Transactional
    public void deleteBeer(Beer beer) {
        beerRepository.deleteById(beer.getId());
    }

}