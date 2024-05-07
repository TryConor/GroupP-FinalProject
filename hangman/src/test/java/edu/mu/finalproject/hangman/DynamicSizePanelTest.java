package edu.mu.finalproject.hangman;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Locale;
import java.util.MissingResourceException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DynamicSizePanelDiffblueTest {
    /**
     * Method under test: {@link DynamicSizePanel#getPreferredSize()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetPreferredSize() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        DynamicSizePanel dynamicSizePanel = null;

        // Act
        Dimension actualPreferredSize = dynamicSizePanel.getPreferredSize();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: default or parameterless constructor of
     * {@link DynamicSizePanel}
     */
    @Test
    void testNewDynamicSizePanel() throws MissingResourceException {
        // Arrange and Act
        DynamicSizePanel actualDynamicSizePanel = new DynamicSizePanel();

        // Assert
        Locale locale = actualDynamicSizePanel.getLocale();
        assertEquals("", locale.getDisplayScript());
        assertEquals("", locale.getDisplayVariant());
        assertEquals("", locale.getScript());
        assertEquals("", locale.getVariant());
        Cursor cursor = actualDynamicSizePanel.getCursor();
        assertEquals("Default Cursor", cursor.getName());
        Font font = actualDynamicSizePanel.getFont();
        
        
    }
}
