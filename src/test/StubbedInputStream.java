package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

class StubbedInputStream extends InputStream {
    private Queue<String> input;

    public StubbedInputStream(Queue<String> input) {
        this.input = input;
    }

    @Override
    public int read(byte[] bytes) throws IOException {
        return super.read(bytes);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int read(byte[] bytes, int i, int i1) throws IOException {
        if(input.isEmpty()) {
            return -1;
        }

        bytes[0] = input.remove().getBytes()[0];
        bytes[1] = "\n".getBytes()[0];
        return 2;
    }

    @Override
    public long skip(long l) throws IOException {
        return super.skip(l);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int available() throws IOException {
        return super.available();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void close() throws IOException {
        super.close();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void mark(int i) {
        super.mark(i);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void reset() throws IOException {
        super.reset();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean markSupported() {
        return super.markSupported();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int read() throws IOException {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static InputStreamBuilder stubInputStream() {
        return new InputStreamBuilder();
    }
}
