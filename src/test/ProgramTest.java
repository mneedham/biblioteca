package test;

import main.Program;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.containsString;
import static test.StubbedInputStream.stubInputStream;

import java.io.*;

public class ProgramTest {
    private PrintStream console;
    private static final String EXIT_CODE = "9";

    @Before
    public void before() {
        console = System.out;
    }

    @Test
    public void showTheNameOfTheLibrary() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn("9").atSomePoint());

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("Welcome to The Bangalore Public Library System"));
    }

    @Test
    public void showTheBooksAvailableForRental() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn("1").then("9").atSomePoint());

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("1. Sweet Valley High vol. 4 by John Travolta "));
        assertThat(outputStream.toString(), containsString("2. eXtreme Programming Explained by Kent Beck "));
        assertThat(outputStream.toString(), containsString("3. How to Win Friends and Influence People by Dale Carnagie "));
        assertThat(outputStream.toString(), containsString("4. How to Cheat at TWU Assignements by Anonymous "));
    }

    @After
    public void after() {
        System.setOut(console);
    }


}
