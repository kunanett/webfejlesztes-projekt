/**
 *
 */
package hu.unideb.inf.beer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "BEER")
@Setter
@Getter
public class BeerEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "ALCOHOL_LEVEL", nullable = false)
    private double alcoholLevel;
    @Column(name = "PRICE", nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private BeerCategoryEntity beerCategoryEntity;
}
