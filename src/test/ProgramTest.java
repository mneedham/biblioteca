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
    private static final String BOOK_LISTING = "1";
    private ByteArrayOutputStream outputStream;
    private static final String TALK_TO_LIBRARIAN = "3";
    private static final String CHECK_OUT_BOOK = "2";

    @Before
    public void before() {
        console = System.out;
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void show_the_name_of_the_library() throws IOException {
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn(EXIT_CODE).atSomePoint());

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("Welcome to The Bangalore Public Library System"));
    }

    @Test
    public void show_the_books_available_for_rental() throws IOException {
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn(BOOK_LISTING).then(EXIT_CODE).atSomePoint());

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("1. Sweet Valley High vol. 4 by John Travolta "));
        assertThat(outputStream.toString(), containsString("2. eXtreme Programming Explained by Kent Beck "));
        assertThat(outputStream.toString(), containsString("3. How to Win Friends and Influence People by Dale Carnagie "));
        assertThat(outputStream.toString(), containsString("4. How to Cheat at TWU Assignements by Anonymous "));
    }

    @Test
    public void check_out_a_book() {
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn(CHECK_OUT_BOOK).then("1").then(EXIT_CODE).atSomePoint());

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("Thank You! Enjoy the book."));
    }

    @Test
    public void check_out_a_book_that_isnt_available() {
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn(CHECK_OUT_BOOK).then("5").then(EXIT_CODE).atSomePoint());

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("Sorry we don't have that book yet."));
    }

    @Test
    public void talk_to_librarian() {
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn(TALK_TO_LIBRARIAN).then(EXIT_CODE).atSomePoint());

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("Please talk to Librarian. Thank you."));
    }

    @Test
    public void invalid_entry() {
        System.setOut(new PrintStream(outputStream));
        System.setIn(stubInputStream().toReturn("a").then(EXIT_CODE).atSomePoint());

        Program.main(new String[]{});

        assertThat(outputStream.toString(), containsString("Enter a valid integer!!"));
    }

    @After
    public void after() {
        System.setOut(console);
    }


}
