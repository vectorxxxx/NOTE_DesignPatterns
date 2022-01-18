package com.vectorx.pattern.t21_strategy.improve.duck;

import com.vectorx.pattern.t21_strategy.improve.fly.NoFlyBehavior;
import com.vectorx.pattern.t21_strategy.improve.quark.NoQuarkBehavior;
import com.vectorx.pattern.t21_strategy.improve.swim.NoSwimHehavior;

/**
 * 玩具鸭
 */
public class ToyDuck extends Duck {
    public ToyDuck() {
        super();
        quarkBehavior = new NoQuarkBehavior();
        swimBehavior = new NoSwimHehavior();
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("======玩具鸭======");
    }
}
