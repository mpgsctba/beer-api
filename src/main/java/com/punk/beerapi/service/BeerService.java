package com.punk.beerapi.service;

import com.punk.beerapi.entities.Beer;
import com.punk.beerapi.repository.BeerRepository;
import com.punk.beerapi.util.Constants;
import com.punk.beerapi.util.PageableUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * @author marcossilva
 */
@Slf4j
@Service
@AllArgsConstructor
public class BeerService {

    private final BeerRepository repository;

    /**
     * Find Beer by ID
     *
     * @param id
     * @return
     */
    public Beer findById(Long id) {
        return Optional.ofNullable(this.repository.findById(id))
                .get()
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("No beer found that matches the ID %s", id)));

    }

    /**
     * Find all beers
     *
     * @param filter
     * @param favorite
     * @param page
     * @param itemsPerPage
     * @return
     */
    public Page<Beer> findAll(final String filter, final Boolean favorite, final Long page, final Long itemsPerPage) {
        final Pageable pageable = PageableUtil.buildPageable(page, itemsPerPage);
        return this.repository.findByFilter(filter, favorite, pageable);
    }

    /**
     * Update property favorite
     *
     * @param id
     * @param favorite
     * @return
     */
    public Beer updateFavorite(final Long id, final Boolean favorite) {
        final Beer beer = this.findById(id);
        beer.setFavorite(favorite);
        return this.repository.save(beer);
    }
}
