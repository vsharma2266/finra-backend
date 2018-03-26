package com.finra.demo.domain;

import java.util.Map;

/**
 * The interface Config service.
 */
public interface ConfigService {

    /**
     * Gets mapping.
     *
     * @return the mapping
     */
    Map<String, String> getMapping();

    /**
     * Sets mapping.
     *
     * @param key the key
     */
    void setMapping(String key);
}

