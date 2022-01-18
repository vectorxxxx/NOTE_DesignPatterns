package com.vectorx.pattern.t21_strategy.improve.quark;

/**
 * “嘎嘎叫”行为策略对象
 */
public class GagaQuarkBehavior implements QuarkBehavior {
    @Override
    public void quark() {
        System.out.println("嘎嘎叫~");
    }
}
