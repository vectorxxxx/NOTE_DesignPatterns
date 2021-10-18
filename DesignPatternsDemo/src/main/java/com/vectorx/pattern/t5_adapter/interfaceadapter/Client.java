package com.vectorx.pattern.t5_adapter.interfaceadapter;

public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            @Override
            public void operation1() {
                System.out.println("调用operation1方法");
            }
        };
        absAdapter.operation1();
    }
}
