package com.fizzbuzz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class FizzbuzzControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   
   @Test
   public void getFizzbuzzList() throws Exception {
      Integer id = 1;   //"id" is the first value of the list that should be returned by the api. The upper limit is set to 100 in the application.properties file.
      String uri = "/fizzbuzz?startValue=" + id;
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri,id).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status); //If the request is ok, the status should be 200.
      
      String content = mvcResult.getResponse().getContentAsString();
      String[] fizzbuzzlist = super.mapFromJson(content, String[].class);
      assertTrue(fizzbuzzlist.length == 100); //If the length of the returned list is 100 means that the list goes from 1 to 100.
   }
}