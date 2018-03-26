package com.finra.demo.api;

import com.finra.demo.domain.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * The type Config controller.
 */
@RestController
@RequestMapping("/finra")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    /**
     * Gets mappings.
     *
     * @return the mappings
     */
    @GetMapping("/mapping")
    public Map<String, String> getMappings() {
        return configService.getMapping();
    }

    /**
     * Post mapping.
     *
     * @param args the args
     */
    @PostMapping("/mapping")
    public void postMapping(String[] args) {
         configService.setMapping("0");
    }

}
