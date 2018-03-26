package com.finra.demo.apiclient;

import com.finra.demo.domain.ConfigService;
import com.finra.demo.repository.FiraRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * The type Config service client.
 */
@Service
public class ConfigServiceClient implements ConfigService {

    @Autowired
    private FiraRespository dataStore;

    @Override
    public Map<String, String> getMapping() {
        return dataStore.getMapping();
    }

    @Override
    public void setMapping(String key) {
//        jdbcTemplate.update("insert into keymapping values('0', 'abcd')");
    }



}

