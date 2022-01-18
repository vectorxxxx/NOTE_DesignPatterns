package com.vectorx.pattern.t21_strategy.tradition;

import com.vectorx.pattern.t21_strategy.improve.duck.Duck;

public class PekingDuck extends Duck {
    @Override
    public void display() {
        System.out.println("北京鸭~");
    }

    @Override
    public void fly() {
        System.out.println("北京鸭不会飞~");
    }
}
