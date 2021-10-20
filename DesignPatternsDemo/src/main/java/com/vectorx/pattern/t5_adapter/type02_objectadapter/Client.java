package com.vectorx.pattern.t5_adapter.type02_objectadapter;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charing(new VoltageAdapter(new Voltage220V()));
    }
}