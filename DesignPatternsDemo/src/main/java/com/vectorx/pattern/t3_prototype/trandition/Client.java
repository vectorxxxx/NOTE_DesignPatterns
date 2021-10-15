package com.vectorx.pattern.t3_prototype.trandition;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Sheep sheep = new Sheep("Tom", 1, "白色");
            System.out.println(sheep);
        }
    }
}
