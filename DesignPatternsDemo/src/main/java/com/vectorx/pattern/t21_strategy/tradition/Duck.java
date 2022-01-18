package com.vectorx.pattern.t21_strategy.tradition;

public abstract class Duck {
    public void quark() {
        System.out.println("鸭子嘎嘎叫~");
    }

    public void swim() {
        System.out.println("鸭子哗哗游~");
    }

    public void fly() {
        System.out.println("鸭子腾腾飞~");
    }

    public abstract void display();
}
