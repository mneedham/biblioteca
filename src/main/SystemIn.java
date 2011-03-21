package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIn implements ITakeInput {
    private BufferedReader reader;

    public SystemIn() {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        reader = new BufferedReader(inputStream);
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }
}
