package edu.mu.finalproject.hangman;

import javax.inject.Inject;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StartMenuTest {


	@Inject
	StartMenu underTest;

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
	void testStartMenu() throws Exception {
		new StartMenu();
	}

	@Test
	void testPopulateLevelComboBox() throws Exception {
		// given
		Database database = new Database();
		// when
		underTest.populateLevelComboBox(database);
	}

	@Test
	void testUpdate() throws Exception {
		// given
		Database database = new Database();
		// when
		underTest.update(database);
	}

}