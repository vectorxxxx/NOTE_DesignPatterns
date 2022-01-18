package com.vectorx.pattern.t21_strategy.improve.fly;

/**
 * “不太会飞”行为策略对象
 */
public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不太会飞~");
    }
}
