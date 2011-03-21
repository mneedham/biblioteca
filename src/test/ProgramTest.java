package test;

import main.Program;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.containsString;

import java.io.*;

public class ProgramTest {
    private PrintStream console;
    private static final String EXIT_CODE = "9";

    @Before
    public void before() {
        console = System.out;
    }

    @Test
    public void screwYouBuffer() throws IOException {
//        System.setIn(new StubbedInputStream());

        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);

        System.out.println(reader.readLine());

        InputStreamReader inputStream2 = new InputStreamReader(System.in);
        BufferedReader reader2 = new BufferedReader(inputStream);

        String value2 = reader2.readLine();
        System.out.println(value2);
    }

    @Test
    public void showTheNameOfTheLibrary() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(new BufferedInputStream(new ByteArrayInputStream("9\n".getBytes())));

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("Welcome to The Bangalore Public Library System"));
    }

    @Test
    public void showTheBooksAvailableForRental() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        System.setIn(new BufferedInputStream(new ByteArrayInputStream("1\n9\n".getBytes())));

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("2. eXtreme Programming Explained by Kent Beck"));
    }

    @After
    public void after() {
        System.setOut(console);
    }


}
