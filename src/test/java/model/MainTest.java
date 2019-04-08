package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void getSizeOfWindowTest () {
        double expectedWidth = Main.getWindowWidth();
        double actualWidth = 900;
        assertEquals(actualWidth, expectedWidth, 0.01);
    }
}