package com.punk.beerapi.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author marcossilva
 */
public class PageableUtil {

    private PageableUtil() {

    }

    public static Pageable buildPageable(Long page, Long itemsPerPage) {
        return PageRequest.of(page == null ? 0 : page.intValue(),
                itemsPerPage == null ? Constants.ITEMS_PER_PAGE_DEFAULT : itemsPerPage.intValue(), Sort.unsorted());
    }
}
