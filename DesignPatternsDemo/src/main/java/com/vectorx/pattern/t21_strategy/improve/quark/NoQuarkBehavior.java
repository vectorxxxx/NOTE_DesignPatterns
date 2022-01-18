package com.vectorx.pattern.t21_strategy.improve.quark;

/**
 * “不会叫”行为策略对象
 */
public class NoQuarkBehavior implements QuarkBehavior {
    @Override
    public void quark() {
        System.out.println("不会叫~");
    }
}
