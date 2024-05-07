package edu.mu.finalproject.hangman;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainIntegrationTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@BeforeAll
	 static void setUpBeforeClass() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@AfterAll
	 static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	void testMain() throws Exception {
		// given
		String[] args = new String[]{"TestArgs"};
		// when
		Main.main(args);
	}

}