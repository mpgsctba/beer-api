package com.punk.beerapi.dto;

import com.punk.beerapi.entities.Beer;
import lombok.Builder;
import lombok.Data;

/**
 * @author marcossilva
 */
@Data
@Builder
public class BeerDto {
    private Long id;
    private String name;
    private String tagline;
    private String first_brewed;
    private String description;
    private String image_url;
    private Double abv;
    private Double ibu;
    private Integer ebc;
    private Integer srm;
    private Double ph;
    private Integer attenuation_level;
    private ValueDto volume;
    private ValueDto boil_volume;
    private Boolean favorite;

    public static BeerDto toDto(final Beer e) {
        if (e == null) {
            return null;
        }
        return BeerDto.builder()
                .id(e.getId())
                .name(e.getName())
                .tagline(e.getTagline())
                .first_brewed(e.getFirst_brewed())
                .description(e.getDescription())
                .image_url(e.getImage_url())
                .abv(e.getAbv())
                .ibu(e.getIbu())
                .ebc(e.getEbc())
                .srm(e.getSrm())
                .ph(e.getPh())
                .attenuation_level(e.getAttenuation_level())
                .volume(ValueDto.builder().value(e.getVolume_value()).unit(e.getVolume_unit()).build())
                .boil_volume(ValueDto.builder().value(e.getBoil_volume_value()).unit(e.getBoil_volume_unit()).build())
                .favorite(e.isFavorite())
                .build();
    }
}
