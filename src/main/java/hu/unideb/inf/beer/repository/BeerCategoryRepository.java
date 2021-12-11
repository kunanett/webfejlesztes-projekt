package hu.unideb.inf.beer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.beer.entity.BeerCategoryEntity;

@Repository
public interface BeerCategoryRepository extends JpaRepository<BeerCategoryEntity, Long> {

	BeerCategoryEntity findByName(String name);
}