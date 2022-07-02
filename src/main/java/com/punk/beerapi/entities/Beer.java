package com.punk.beerapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author marcossilva
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "beer")
public class Beer {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String tagline;

    @Column
    private String first_brewed;

    @Column(length = 2000)
    private String description;

    @Column
    private String image_url;

    @Column
    private Double abv;

    @Column
    private Double ibu;

    @Column
    private Integer ebc;

    @Column
    private Integer srm;

    @Column
    private Double ph;

    @Column
    private Integer attenuation_level;

    @Column
    private Double volume_value;

    @Column
    private String volume_unit;

    @Column
    private Double boil_volume_value;

    @Column
    private String boil_volume_unit;

    @Column
    private boolean favorite;
}
