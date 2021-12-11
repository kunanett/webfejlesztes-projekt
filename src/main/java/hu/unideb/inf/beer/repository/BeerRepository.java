package hu.unideb.inf.beer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.beer.entity.BeerEntity;

@Repository
public interface BeerRepository extends JpaRepository<BeerEntity, Long> {
}