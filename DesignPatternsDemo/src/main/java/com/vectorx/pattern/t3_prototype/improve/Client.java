package com.vectorx.pattern.t3_prototype.improve;

public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("Tom", 1, "白色");
        for (int i = 0; i < 10; i++) {
            Sheep sheep1 = (Sheep) sheep.clone();
            System.out.println(sheep1);
        }
    }
}
