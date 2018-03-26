package com.finra.demo.api;

import com.finra.demo.domain.InputService;
import com.finra.demo.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Phone controller.
 */
@RestController
@RequestMapping(value = "/finra")
public class PhoneController {

    @Autowired
    private InputService inputService;

    /**
     * Add phone list.
     *
     * @param phoneNumber the phone number
     * @param pagesize    the pagesize
     * @return the list
     */
    @PostMapping(value = "/{phoneNumber}")
    public List<String> addPhone(
            @PathVariable String phoneNumber,
            @RequestParam(value = "pagesize", required = false, defaultValue = "20") Long pagesize) {
        if (phoneNumber.length() != 7 && phoneNumber.length() != 10) {
            throw new InvalidInputException();
        }
        return inputService.addListAndReturnSome(phoneNumber, pagesize);
    }

    /**
     * Gets phone.
     *
     * @param page     the page
     * @param pagesize the pagesize
     * @return the phone
     */
    @GetMapping(value = "/{phoneNumber}")
    public List<String> getPhone(
            @RequestParam(value = "page", required = true) Long page,
            @RequestParam(value = "pagesize", required = false, defaultValue = "20") Long pagesize) {
        System.out.println(pagesize);
        return inputService.getCombinations(page, pagesize);
    }

    /**
     * Validation exception string.
     *
     * @param exception the exception
     * @return the string
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({InvalidInputException.class})
    public String validationException(InvalidInputException exception) {

        return "Invalid input";
    }
}
