package edu.mu.finalproject.hangman;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;

	class DatabaseDiffblueTest {
	    /**
	     * Method under test: {@link Database#addCategory(String, Map)}
	     */
	    @Test
	    void testAddCategory() {
	        // Arrange
	        Database database = new Database();

	        // Act
	        database.addCategory("Category", new HashMap<>());

	        // Assert
	        assertEquals(1, database.getCategories().size());
	    }

	    /**
	     * Method under test: {@link Database#notifyObservers()}
	     */
	    @Test
	    void testNotifyObservers() {
	        // Arrange
	        Database database = new Database();

	        // Act
	        database.notifyObservers();

	        // Assert that nothing has changed
	        assertTrue(database.getCategories().isEmpty());
	    }

	    /**
	     * Method under test: {@link Database#notifyObservers()}
	     */
	    @Test
	    @Disabled("TODO: Complete this test")
	    void testNotifyObservers2() {
	        // TODO: Diffblue Cover was only able to create a partial test for this method:
	        //   Reason: No inputs found that don't throw a trivial exception.
	        //   Diffblue Cover tried to run the arrange/act section, but the method under
	        //   test threw
	        //   java.lang.NullPointerException: Cannot invoke "edu.mu.Game.Observer.update(edu.mu.Game.Database)" because "observer" is null
	        //       at edu.mu.Game.Database.notifyObservers(Database.java:33)
	        //   See https://diff.blue/R013 to resolve this issue.

	        // Arrange
	        Database database = new Database();
	        database.addObserver(null);

	        // Act
	        database.notifyObservers();
	    }

	    /**
	     * Method under test: {@link Database#addObserver(Observer)}
	     */
	    @Test
	    @Disabled("TODO: Complete this test")
	    void testAddObserver() {
	        // TODO: Diffblue Cover was only able to create a partial test for this method:
	        //   Diffblue AI was unable to find a test

	        // Arrange
	        // TODO: Populate arranged inputs
	        Database database = null;
	        Observer observer = null;

	        // Act
	        database.addObserver(observer);

	        // Assert
	        // TODO: Add assertions on result
	    }

	    /**
	     * Method under test: {@link Database#removeObserver(Observer)}
	     */
	    @Test
	    @Disabled("TODO: Complete this test")
	    void testRemoveObserver() {
	        // TODO: Diffblue Cover was only able to create a partial test for this method:
	        //   Diffblue AI was unable to find a test

	        // Arrange
	        // TODO: Populate arranged inputs
	        Database database = null;
	        Observer observer = null;

	        // Act
	        database.removeObserver(observer);

	        // Assert
	        // TODO: Add assertions on result
	    }

	    /**
	     * Methods under test:
	     * <ul>
	     *   <li>default or parameterless constructor of {@link Database}
	     *   <li>{@link Database#setCategories(Map)}
	     *   <li>{@link Database#getCategories()}
	     * </ul>
	     */
	    @Test
	    void testGettersAndSetters() {
	        // Arrange and Act
	        Database actualDatabase = new Database();
	        HashMap<String, Map<String, List<String>>> categories = new HashMap<>();
	        actualDatabase.setCategories(categories);

	        // Assert that nothing has changed
	        assertSame(categories, actualDatabase.getCategories());
	    }
	}


