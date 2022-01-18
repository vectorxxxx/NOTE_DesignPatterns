package com.vectorx.pattern.t21_strategy.improve.duck;

import com.vectorx.pattern.t21_strategy.improve.fly.BadFlyBehavior;
import com.vectorx.pattern.t21_strategy.improve.quark.GagaQuarkBehavior;
import com.vectorx.pattern.t21_strategy.improve.swim.CanSwimHehavior;

/**
 * 北京鸭
 */
public class PekingDuck extends Duck {
    public PekingDuck() {
        super();
        quarkBehavior = new GagaQuarkBehavior();
        swimBehavior = new CanSwimHehavior();
        flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("======北京鸭======");
    }
}
