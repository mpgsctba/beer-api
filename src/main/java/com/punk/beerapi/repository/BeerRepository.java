package com.punk.beerapi.repository;

import com.punk.beerapi.entities.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author marcossilva
 */
public interface BeerRepository extends JpaRepository<Beer, Long> {

    /**
     * Filter by name or description
     *
     * @param filter
     * @param pageable
     * @return @Page
     */
    @Query("select b from Beer b where (:filter is null " +
            " or (b.name is not null and lower(b.name) like lower(concat('%', :filter,'%'))) " +
            " or (b.description is not null and lower(b.description) like lower(concat('%', :filter,'%'))))" +
            " and (:favorite is null or b.favorite = :favorite)")
    Page<Beer> findByFilter(@Param("filter") String filter, @Param("favorite") Boolean favorite, final Pageable pageable);
}
