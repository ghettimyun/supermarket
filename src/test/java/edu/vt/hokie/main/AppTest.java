package edu.vt.hokie.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testMain() {
        String args[] = {"src/test/java/edu/vt/hokie/inputs/test.txt", "src/test/java/edu/vt/hokie/inputs/testSetUp.txt"};
        App.main(args);
        String[] lines = outContent.toString().split("\n");
        String subtotal = lines[lines.length - 4];
        assertEquals("SUBTOTAL:               $102.00", subtotal);
    }

    @Test
    public void testDefaultMain() {
        String args[] = {"src/test/java/edu/vt/hokie/inputs/test.txt"};
        App.main(args);
        String[] lines = outContent.toString().split("\n");
        String subtotal = lines[lines.length - 4];
        assertEquals("SUBTOTAL:               $89.10", subtotal);
    }
}
