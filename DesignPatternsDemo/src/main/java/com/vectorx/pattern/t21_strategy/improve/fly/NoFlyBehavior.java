package com.vectorx.pattern.t21_strategy.improve.fly;

/**
 * “不会飞”行为策略对象
 */
public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞~");
    }
}
