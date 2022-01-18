package com.vectorx.pattern.t21_strategy.tradition;

import com.vectorx.pattern.t21_strategy.improve.duck.Duck;

public class ToyDuck extends Duck {
    @Override
    public void display() {
        System.out.println("玩具鸭~");
    }

    @Override
    public void quark() {
        System.out.println("玩具鸭不会叫~");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不会游~");
    }

    @Override
    public void fly() {
        System.out.println("玩具鸭不会飞~");
    }
}
