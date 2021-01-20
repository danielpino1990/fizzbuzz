package com.fizzbuzz;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.fizzbuzz.controller.FizzBuzzList;

public class FizzbuzzListClassTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }

   @Test
   public void createListTest() {
      
      // Given
      int startValue = 10;
      int upperLimit = 20;
      
      FizzBuzzList fbl = new FizzBuzzList();
      
      List<String> expected = new ArrayList<String>();//List that should be returned by the method.
         expected.add("Buzz");
         expected.add("11");
         expected.add("Fizz");
         expected.add("13");
         expected.add("14");
         expected.add("FizzBuzz");
         expected.add("16");
         expected.add("17");
         expected.add("Fizz");
         expected.add("19");
         expected.add("Buzz");

      List<String> result = fbl.createList(startValue, upperLimit);//List returned by the method.

      assertEquals(expected, result);
   }

}
