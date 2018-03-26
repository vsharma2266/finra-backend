package com.finra.demo.domain;

import java.util.List;

/**
 * The interface Input service.
 */
public interface InputService {

    /**
     * Add list and return some list.
     *
     * @param combinations the combinations
     * @param pagesize     the pagesize
     * @return the list
     */
    List<String> addListAndReturnSome(String combinations, Long pagesize);

    /**
     * Gets combinations.
     *
     * @param page     the page
     * @param pagesize the pagesize
     * @return the combinations
     */
    List<String> getCombinations(Long page, Long pagesize);
}
