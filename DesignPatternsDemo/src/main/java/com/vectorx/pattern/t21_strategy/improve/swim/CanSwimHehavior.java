package com.vectorx.pattern.t21_strategy.improve.swim;

/**
 * “会游泳”行为策略对象
 */
public class CanSwimHehavior implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("会游泳~");
    }
}
