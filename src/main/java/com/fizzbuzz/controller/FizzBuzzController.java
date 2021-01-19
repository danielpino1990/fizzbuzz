package com.fizzbuzz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.fizzbuzz.CustomExceptions.*;
import com.google.gson.Gson;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@RestController
public class FizzBuzzController {

    @Value("${upperLimit}")
    int upperLimit;
    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzList.class);
    
    @RequestMapping(value = "/fizzbuzz", method = RequestMethod.GET, produces = "application/json")
    public String fizzBuzz(@RequestParam Integer startValue) throws CustomException {
        logger.info("Starting fizzBuzz method from FizzBuzzController class (@RequestMapping)");
        FizzBuzzList fbl = new FizzBuzzList();
        String message;

        try{
            if(startValue instanceof Integer){//Check if startValue is not null, integer, and between 1 and upperLimit. 
                                              //If any of this conditions fail a CustomException is thrown.
                if(startValue<1){ 
                    message = "Non positive parameter. Please try with a value > 0";
                    throw new CustomException(message);
                }
                else if(startValue>upperLimit){
                    message = "\"startValue\" can't be higher than " + upperLimit + ". Please try with a lower value."; 
                    throw new CustomException(message);
                }
            } else {
                if(startValue==null){ 
                    message = "\"startValue\" can't be null. Please try with a non null value.";
                    throw new CustomException(message);
                }
            }
        }
        catch(CustomException e){
            logger.error(e.getMessage());
            return e.getMessage();
        }
        logger.info("Ending fizzBuzz method from FizzBuzzController class (@RequestMapping)");
        return new Gson().toJson(fbl.createList(startValue, upperLimit));
    }

    // Return this error if startValue is not an integer.
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public void handleParameterTypeMismatch(IllegalArgumentException e, HttpServletResponse response)
            throws IOException {
                String message = "This value is not an integer. Please try with an integer value.";
                logger.error(message);
        response.sendError(HttpStatus.BAD_REQUEST.value(),message);
    }
}