package test;

import java.util.LinkedList;
import java.util.Queue;

public class InputStreamBuilder {
    private Queue<String> values = new LinkedList<String>();

    public InputStreamBuilder returns(String value) {
        this.values.add(value);
        return this;
    }

    public InputStreamBuilder then(String value) {
        this.values.add(value);
        return this;
    }

    public StubbedInputStream asInputStream() {
        return new StubbedInputStream(values);
    }
}
