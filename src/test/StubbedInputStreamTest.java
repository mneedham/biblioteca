package test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.io.IOException;


public class StubbedInputStreamTest {

    @Test
    public void shouldLetUsStubOutAnInputStream() throws IOException {
        StubbedInputStream inputStream = new StubbedInputStream();

        byte[] bytes = new byte[8192];
        inputStream.read(bytes, 0, 8192);

        assertThat(bytes[0], is("9".getBytes()[0]));
        assertThat(bytes[1], is("\n".getBytes()[0]));

    }
}
