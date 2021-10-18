package com.vectorx.pattern.t5_adapter.classadapter;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charing(new VoltageAdapter());
    }
}
