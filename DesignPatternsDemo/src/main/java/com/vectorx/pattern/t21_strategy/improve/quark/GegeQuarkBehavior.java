package com.vectorx.pattern.t21_strategy.improve.quark;

/**
 * “咯咯叫”行为策略对象
 */
public class GegeQuarkBehavior implements QuarkBehavior {
    @Override
    public void quark() {
        System.out.println("咯咯叫~");
    }
}
