package edu.mu.finalproject.hangman;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Locale;
import org.junit.jupiter.api.Test;

class DynamicSizePanelDiffblueTest {
    /**
     * Method under test: {@link DynamicSizePanel#getPreferredSize()}
     */
    @Test
    void testGetPreferredSize() {
        // Arrange
        DynamicSizePanel dynamicSizePanel = new DynamicSizePanel();

        // Act
        Dimension actualPreferredSize = dynamicSizePanel.getPreferredSize();

        // Assert
        assertNotNull(actualPreferredSize);
        assertEquals(Toolkit.getDefaultToolkit().getScreenSize().getWidth(), actualPreferredSize.getWidth());
        assertEquals(Toolkit.getDefaultToolkit().getScreenSize().getHeight(), actualPreferredSize.getHeight());
    }

    @Test
    void testGetPreferredSize_Null() {
        // Arrange
        DynamicSizePanel dynamicSizePanel = null;

        // Act and Assert
        assertNull(dynamicSizePanel);
    }

    /**
     * Method under test: default or parameterless constructor of
     * {@link DynamicSizePanel}
     */
    @Test
    void testNewDynamicSizePanel() {
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

    @Test
    void testNewDynamicSizePanel_DifferentLocale() {
        // Arrange
        Locale locale = new Locale("fr", "FR");
        DynamicSizePanel dynamicSizePanel = new DynamicSizePanel();

        // Act
        dynamicSizePanel.setLocale(locale);

        // Assert
        assertEquals(locale, dynamicSizePanel.getLocale());
    }
}