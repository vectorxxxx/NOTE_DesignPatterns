package com.vectorx.pattern.t21_strategy.improve.duck;

import com.vectorx.pattern.t21_strategy.improve.fly.GoodFlyBehavior;
import com.vectorx.pattern.t21_strategy.improve.quark.GegeQuarkBehavior;
import com.vectorx.pattern.t21_strategy.improve.swim.CanSwimHehavior;

/**
 * 野鸭子
 */
public class WildDuck extends Duck {
    public WildDuck() {
        super();
        quarkBehavior = new GegeQuarkBehavior();
        swimBehavior = new CanSwimHehavior();
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("======野鸭子======");
    }
}
