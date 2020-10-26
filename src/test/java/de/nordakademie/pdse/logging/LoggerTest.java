package de.nordakademie.pdse.logging;

import de.nordakademie.pdse.grid.GridFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertArrayEquals;

public class LoggerTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @After
    public void after() {
        outputStreamCaptor.reset();
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testAddGridToFile() {
        String expectedOutput = "###2\n" +
                "0000\n" +
                "0000\n" +
                "0000\n" +
                "0000\n" + "\n";
        System.setOut(new PrintStream(outputStreamCaptor));
        Logger log = new Logger("file");
        log.addGridToLog(new GridFactory(4, 4, "GridArray").getGrid().toString(), 2);
        StringBuilder current= new StringBuilder();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(log.getFile()));
            while ((line = reader.readLine()) != null){
                current.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        current.append("\n");

        assertArrayEquals(expectedOutput.toCharArray(), current.toString().toCharArray());

    }

    @Test
    public void testAddGridToLogConsole() {
        String expectedOutput = "###2\n" +
                "0000\n" +
                "0000\n" +
                "0000\n" +
                "0000\n" + "\r" + "\n";
        System.setOut(new PrintStream(outputStreamCaptor));
        Logger log = new Logger("console");
        log.addGridToLog(new GridFactory(4, 4, "GridArray").getGrid().toString(), 2);
        int x  = 0;
        String current = outputStreamCaptor.toString();
        assertArrayEquals(expectedOutput.toCharArray(), current.toCharArray());

    }

}