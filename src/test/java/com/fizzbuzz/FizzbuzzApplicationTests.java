package com.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import com.fizzbuzz.controller.FizzBuzzController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzbuzzApplicationTests {

	@Autowired
	private FizzBuzzController controller;
	
	@Test
	public void contextLoads() { //Test that will fail if the application context cannot start.
		assertThat(controller).isNotNull(); //Check if the context is creating the FizzBuzzController.
	}
}
