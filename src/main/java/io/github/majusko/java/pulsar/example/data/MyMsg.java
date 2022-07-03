package io.github.majusko.java.pulsar.example.data;

public class MyMsg {

    private String data;

    public MyMsg(String data) {
        this.data = data;
    }

    public MyMsg() {}

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MyMsg{" +
                "data='" + data + '\'' +
                '}';
    }
}
