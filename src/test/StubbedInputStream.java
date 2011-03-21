package test;

import java.io.IOException;
import java.io.InputStream;

class StubbedInputStream extends InputStream {
    private String[] input;
    private int hasReturned;

    public StubbedInputStream(String... input) {
        this.input = input;
        this.hasReturned = 0;
    }


    @Override
    public int read(byte[] bytes) throws IOException {
        return super.read(bytes);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public int read(byte[] bytes, int i, int i1) throws IOException {
        if(hasReturned >= 2) {
            return -1;
        }

        bytes[0] = "9".getBytes()[0];
        bytes[1] = "\n".getBytes()[0];
        hasReturned++;
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
}
