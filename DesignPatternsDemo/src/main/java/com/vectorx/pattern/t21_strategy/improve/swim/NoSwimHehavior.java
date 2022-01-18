package com.vectorx.pattern.t21_strategy.improve.swim;

/**
 * “不会游泳”行为策略对象
 */
public class NoSwimHehavior implements SwimBehavior {
    @Override
    public void swim() {
        System.out.println("不会游泳~");
    }
}
