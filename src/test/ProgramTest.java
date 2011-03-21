package test;

import main.ITakeInput;
import main.Program;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.containsString;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

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

        ITakeInput fakeSystemIn = new FakeInputStream("9");
        new Program(fakeSystemIn).execute();

        assertThat(outputStream.toString(), containsString("Welcome to The Bangalore Public Library System"));
    }

    @Test
    public void showTheBooksAvailableForRental() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        System.setIn(new FakeInputStream("1", "9"));

        ITakeInput fakeSystemIn = new FakeInputStream("1", "9");

        new Program(fakeSystemIn).execute();

        assertThat(outputStream.toString(), containsString("2. eXtreme Programming Explained by Kent Beck"));
    }

    @After
    public void after() {
        System.setOut(console);
    }

    class FakeInputStream extends InputStream implements ITakeInput {
        private String[] input;
        private int index;

        public FakeInputStream(String... input) {
            this.input = input;
        }

        public String readLine() throws IOException {
            String value = input[index];
            index++;
            return value;
        }

        @Override
        public int read() throws IOException {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
