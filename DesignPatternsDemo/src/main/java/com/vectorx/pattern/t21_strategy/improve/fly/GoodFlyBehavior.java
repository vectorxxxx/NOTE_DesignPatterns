package com.vectorx.pattern.t21_strategy.improve.fly;

/**
 * “很会飞”行为策略对象
 */
public class GoodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("很会飞~");
    }
}
