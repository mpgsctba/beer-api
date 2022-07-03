package com.punk.beerapi.controller;

import com.punk.beerapi.dto.BeerDto;
import com.punk.beerapi.service.BeerService;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author marcossilva
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/beers", produces = MediaType.APPLICATION_JSON_VALUE)
public class BeerController {

    private final BeerService service;

    @GetMapping
    public ResponseEntity<Page<BeerDto>> findAll(@RequestParam(value = "filter", required = false) String filter,
                                                 @RequestParam(value = "favorite", required = false) Boolean favorite,
                                                 @RequestParam(value = "page", required = false) Long page,
                                                 @RequestParam(value = "itemsPerPage", required = false) Long itemsPerPage) {
        final Page<BeerDto> data = this.service.findAll(filter, favorite, page, itemsPerPage).map(BeerDto::toDto);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BeerDto> findById(
            @ApiParam(name = "id", type = "Long", example = "1") @PathVariable Long id) {
        return new ResponseEntity<>(BeerDto.toDto(this.service.findById(id)), HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}/favorite/{favorite}")
    public ResponseEntity<BeerDto> updateFavorite(
            @ApiParam(name = "id", type = "Long", example = "1") @PathVariable Long id,
            @ApiParam(name = "favorite", type = "boolean", example = "true or false") @PathVariable Boolean favorite) {
        return new ResponseEntity<>(BeerDto.toDto(this.service.updateFavorite(id, favorite)), HttpStatus.OK);
    }
}
