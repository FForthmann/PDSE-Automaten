package de.nordakademie.pdse.logging;

import de.nordakademie.pdse.grid.GridFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertArrayEquals;

public class TestConsoleAndFileOutput {

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
    public void testAddGridToLogToConsoleAndToFile() {
        String expectedConsoleOutput = "###2\n" +
                "0000\n" +
                "0000\n" +
                "0000\n" +
                "0000\n" + "\r\n";
        String expectedFileOutput = "###2\n" +
                "0000\n" +
                "0000\n" +
                "0000\n" +
                "0000\n" + "\n\n";
        System.setOut(new PrintStream(outputStreamCaptor));
        Logger log = new Logger("consoleAndFile");
        log.addGridToLog(new GridFactory(4, 4, "GridArray").getGrid().toString(), 2);
        String currentConsole = outputStreamCaptor.toString();
        StringBuilder currentFile = new StringBuilder();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(log.getFile()));
            while ((line = reader.readLine()) != null) {
                currentFile.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentFile.append("\n");

        assertArrayEquals(expectedFileOutput.toCharArray(), currentFile.toString().toCharArray());

        assertArrayEquals(expectedConsoleOutput.toCharArray(), currentConsole.toCharArray());
    }
}
