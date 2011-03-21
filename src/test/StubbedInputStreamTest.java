package test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static test.StubbedInputStream.stubInputStream;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class StubbedInputStreamTest {

    @Test
    public void shouldLetUsStubOutAnInputStream() throws IOException {
        Queue<String> input = new PriorityQueue<String>();
        input.offer("9");
        StubbedInputStream inputStream = new StubbedInputStream(input);

        byte[] bytes = new byte[8192];
        inputStream.read(bytes, 0, 8192);

        assertThat(bytes[0], is("9".getBytes()[0]));
        assertThat(bytes[1], is("\n".getBytes()[0]));
    }

    @Test
    public void queue() {
        Queue<String> queue = new LinkedList<String>();
        queue.add("Mark");
        queue.add("Jim");

        assertThat(queue.remove(), is("Mark"));
        assertThat(queue.remove(), is("Jim"));
    }

    @Test
    public void should_let_us_choose_values_in_input_stream() throws IOException {
        StubbedInputStream inputStream = stubInputStream().toReturn("9").then("1").then("3").atSomePoint();

        byte[] bytes = new byte[8192];
        inputStream.read(bytes, 0, 8192);

        assertThat(bytes[0], is("9".getBytes()[0]));

        bytes = new byte[8192];
        inputStream.read(bytes, 0, 8192);

        assertThat(bytes[0], is("1".getBytes()[0]));

        bytes = new byte[8192];
        inputStream.read(bytes, 0, 8192);

        assertThat(bytes[0], is("3".getBytes()[0]));
    }

    @Test
    public void should_let_us_have_inputs_of_more_than_one_character() throws IOException {
        StubbedInputStream inputStream = stubInputStream().toReturn("mark").atSomePoint();

        byte[] bytes = new byte[8192];
        inputStream.read(bytes, 0, 8192);

        assertThat(bytes[0], is("m".getBytes()[0]));
        assertThat(bytes[1], is("a".getBytes()[0]));
        assertThat(bytes[2], is("r".getBytes()[0]));
        assertThat(bytes[3], is("k".getBytes()[0]));
    }


    @Test
    public void fluentInterface() {
        stubInputStream().toReturn("9").then("1").atSomePoint();
    }
}
