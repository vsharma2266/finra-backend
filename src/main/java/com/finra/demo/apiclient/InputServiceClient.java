package com.finra.demo.apiclient;

import com.finra.demo.domain.InputService;
import com.finra.demo.repository.FiraRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.toIntExact;

/**
 * The type Input service client.
 */
@Service
public class InputServiceClient implements InputService {

    private static final Integer DEFAULT_PAGE_SIZE = 20;
    @Autowired
    private FiraRespository dataStore;
    @Autowired
    private ConfigServiceClient configServiceClient;

    @Override
    public List<String> addListAndReturnSome(String combinations, Long pagesize) {

        dataStore.clearDb();
        List<String> combos = letterCombinations(combinations);
        Long size;
        if(pagesize.equals(null)) {
            size = combos.size() > DEFAULT_PAGE_SIZE ? DEFAULT_PAGE_SIZE : pagesize;
        } else {
            size = combos.size() > pagesize ? pagesize : combos.size();
        }
        combos.forEach(combination -> dataStore.addCombination(combination));
        return combos.subList(0, toIntExact(size));
    }

    @Override
    public List<String> getCombinations(Long page, Long pagesize) {
        return dataStore.getCombinations(page, pagesize);
    }


    /**
     * Letter combinations list.
     *
     * @param phoneNumber the phone number
     * @return the list
     */
    public List<String> letterCombinations(String phoneNumber) {
        List<String> combinationList = new ArrayList<>();
        Map<String, String> letterNumberMappings = configServiceClient.getMapping();
        combinationList.add("");

        for (int i = 0; i < phoneNumber.length(); i++) {
            String letterNumberMapping = letterNumberMappings.get(String.valueOf(phoneNumber.charAt(i)));
            List<String> combinationsWithParticularDigit = new ArrayList<>();
            for (int j = 0; j < letterNumberMapping.length(); j++) {

                for (String combination : combinationList) {
                    combination += letterNumberMapping.charAt(j);
                    combinationsWithParticularDigit.add(combination);
                }
            }
            combinationList = combinationsWithParticularDigit;
        }
        return combinationList;
    }
}
