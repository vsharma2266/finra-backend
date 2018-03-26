package com.finra.demo.repository;

import java.util.List;
import java.util.Map;

/**
 * The interface Data store.
 */
public interface DataStore {

    /**
     * Clear db.
     */
    void clearDb();

    /**
     * Add combination.
     *
     * @param combination the combination
     */
    void addCombination(String combination);

    /**
     * Gets combinations.
     *
     * @param page     the page
     * @param pagesize the pagesize
     * @return the combinations
     */
    List<String> getCombinations(Long page, Long pagesize);

    /**
     * Gets mapping.
     *
     * @return the mapping
     */
    Map<String, String> getMapping();

    /**
     * Sets mapping.
     */
    void setMapping();
}
