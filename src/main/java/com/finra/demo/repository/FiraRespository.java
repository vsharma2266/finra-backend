package com.finra.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Fira respository.
 */
@Repository
public class FiraRespository implements DataStore {

    private static final String INSERT_COMBINATIONS_SQL = "insert into combinations values(?)";
    private static final Integer DEFAULT_PAGE_SIZE = 20;
    private static final String DELETE_SQL = "delete from combinations";
    private static final String GET_MAPPINGS_SQL = "select * from keymapping";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void clearDb() {
        jdbcTemplate.update(DELETE_SQL);
    }

    @Override
    public void addCombination(String combination) {
        jdbcTemplate.update(INSERT_COMBINATIONS_SQL,combination);
    }

    @Override
    public List<String> getCombinations(Long page, Long pagesize) {
        Long size = pagesize.equals(null) ? DEFAULT_PAGE_SIZE : pagesize;
        String offset = page==0 ? "" : "OFFSET " + page*size ;

        return jdbcTemplate.queryForList("select * from combinations " + offset + " limit " + size, String.class);
    }

    @Override
    public Map<String, String> getMapping() {
        return jdbcTemplate.query(GET_MAPPINGS_SQL, new CombinationExtractor());
    }

    @Override
    public void setMapping() {

    }
    private class CombinationExtractor implements ResultSetExtractor<Map<String, String>> {
        @Override
        public Map<String, String> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Map<String,String> map = new HashMap<>();
            while (resultSet.next()) {
                map.put(resultSet.getString("KEY"), resultSet.getString("MAPPING"));
            }
            return map;
        }
    }
}
