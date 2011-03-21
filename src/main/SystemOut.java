package main;


public class SystemOut implements IProduceOutput {
    public void println(String value) {
        System.out.println(value);
    }
}
