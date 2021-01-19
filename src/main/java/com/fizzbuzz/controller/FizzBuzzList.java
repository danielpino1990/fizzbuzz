package com.fizzbuzz.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzBuzzList {

    private static final Logger logger = LoggerFactory.getLogger(FizzBuzzList.class);

    public List<String> createList(int startValue, int upperLimit) {
        logger.info("Starting createList method of the FizBuzzList class");

        List<String> fizzBuzzList = new ArrayList<String>(); //ArrayList to store the string values.

        for (int i = startValue; i <= upperLimit; i++) {//From startValue to upperLimit, and depending on the value, the corresponding string is appended to the list.
            logger.debug("Value:" + i);
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                fizzBuzzList.add("Fizz");
            } else if (i % 5 == 0) {
                fizzBuzzList.add("Buzz");
            } else
                fizzBuzzList.add(String.valueOf(i));
        }

        saveListToFile(fizzBuzzList); //Call to the saveListToFile method to save the list in a text file.
        logger.info("Ending createList method of the FizBuzzList class");

        return fizzBuzzList;
    }

    public void saveListToFile(List<String> fizzBuzzList) {
        logger.info("Starting saveListToFile method of the FizBuzzList class");
        logger.debug("Fizzbuzz list to store in a file:" + fizzBuzzList);
 
        try {
            FileWriter writer = new FileWriter("fizzbuzzList.txt", true); //File to store the lists. Passing true to the constructor will append every list to the file instead of overwrite it. 
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYY - HH:mm:ss"); //Pattern for the time signature format.
            LocalDateTime now = LocalDateTime.now(); 
            String time = dtf.format(now); //String that represents the time when the list is being saved to the file in the desired format.
            
            writer.append("Time signature: " + time + "\n\n"); //First line of every list will be a time signature followed by two line breaks for readability reasons.
            writer.append("FizzBuzz list: \n\n"); //Title for the list.

            for (String str : fizzBuzzList) {
                writer.append(str + System.lineSeparator()); //Append every string on the list followed by a break line.
            }
            writer.append("_____________________" + "\n\n"); //Last line will be a set of underscores to separate one list from the next one.
            writer.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Ending saveListToFile method of the FizBuzzList class");
    }
}
