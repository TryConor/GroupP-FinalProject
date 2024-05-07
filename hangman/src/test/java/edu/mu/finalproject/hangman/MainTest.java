package edu.mu.finalproject.hangman;

import static org.assertj.core.api.Assertions.assertThat;

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
		// then
		// TODO check for expected side effect (i.e. service call, changed parameter or exception thrown)
		// verify(mock).methodcall();
		// TestUtils.assertTestFileEquals("someMethod/ParamType_updated.json", TestUtils.objectToJson(param));
		// assertThrows(SomeException.class, () -> underTest.someMethod());
	}

}